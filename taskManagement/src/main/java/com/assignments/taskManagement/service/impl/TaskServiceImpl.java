package com.assignments.taskManagement.service.impl;

import com.assignments.taskManagement.dto.request.TaskCreateRequest;
import com.assignments.taskManagement.dto.request.TaskUpdateRequest;
import com.assignments.taskManagement.dto.response.TaskResponse;
import com.assignments.taskManagement.entity.Task;
import com.assignments.taskManagement.entity.User;
import com.assignments.taskManagement.enums.TaskStatus;
import com.assignments.taskManagement.exception.ResourceNotFoundException;
import com.assignments.taskManagement.exception.UnauthorizedException;
import com.assignments.taskManagement.repository.TaskRepository;
import com.assignments.taskManagement.repository.UserRepository;
import com.assignments.taskManagement.security.CustomUserDetails;
import com.assignments.taskManagement.security.SecurityUtil;
import com.assignments.taskManagement.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final UserRepository userRepository;

    @Override
    public TaskResponse createTask(
            TaskCreateRequest request) {

        User currentUser = getCurrentUser();

        Task task = Task.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .status(TaskStatus.PENDING)
                .userId(currentUser.getId())
                .userName(currentUser.getName())
                .userEmail(currentUser.getEmail())
                .build();

        Task savedTask =
                taskRepository.save(task);

        return mapToResponse(savedTask);
    }

    @Override
    public TaskResponse updateTask(
            String taskId,
            TaskUpdateRequest request) {

        Task task = taskRepository
                .findById(taskId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Task not found"));

        validateOwnership(task);

        if (request.getTitle() != null) {
            task.setTitle(request.getTitle());
        }

        if (request.getDescription() != null) {
            task.setDescription(
                    request.getDescription());
        }

        if (request.getStatus() != null) {
            task.setStatus(request.getStatus());
        }

        Task updatedTask =
                taskRepository.save(task);

        return mapToResponse(updatedTask);
    }

    @Override
    public void deleteTask(
            String taskId) {

        Task task = taskRepository
                .findById(taskId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Task not found"));

        validateOwnership(task);

        taskRepository.delete(task);
    }

    @Override
    public TaskResponse getTaskById(
            String taskId) {

        Task task = taskRepository
                .findById(taskId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Task not found"));

        validateOwnership(task);

        return mapToResponse(task);
    }

    @Override
    public Page<TaskResponse> getMyTasks(
            Pageable pageable) {

        String userId =
                SecurityUtil.getCurrentUserId();

        return taskRepository
                .findByUserId(
                        userId,
                        pageable)
                .map(this::mapToResponse);
    }

    @Override
    public Page<TaskResponse> getAllTasks(
            Pageable pageable) {

        return taskRepository
                .findAll(pageable)
                .map(this::mapToResponse);
    }

    private void validateOwnership(
            Task task) {

        CustomUserDetails currentUser =
                SecurityUtil.getCurrentUser();

        boolean isAdmin =
                currentUser.getUser()
                        .getRole()
                        .name()
                        .equals("ROLE_ADMIN");

        if (isAdmin) {
            return;
        }

        if (!task.getUserId()
                .equals(currentUser
                        .getUser()
                        .getId())) {

            throw new UnauthorizedException(
                    "Access denied");
        }
    }

    private User getCurrentUser() {

        String email =
                SecurityUtil.getCurrentUserEmail();

        return userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found"));
    }

    private TaskResponse mapToResponse(
            Task task) {

        return TaskResponse.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .userId(task.getUserId())
                .userName(task.getUserName())
                .userEmail(task.getUserEmail())
                .build();
    }
}