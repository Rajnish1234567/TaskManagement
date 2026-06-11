package com.assignments.taskManagement.service;

import com.assignments.taskManagement.dto.request.TaskCreateRequest;
import com.assignments.taskManagement.dto.request.TaskUpdateRequest;
import com.assignments.taskManagement.dto.response.TaskResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskService {

    TaskResponse createTask(
            TaskCreateRequest request);

    TaskResponse updateTask(
            String taskId,
            TaskUpdateRequest request);

    void deleteTask(
            String taskId);

    Page<TaskResponse> getMyTasks(
            Pageable pageable);

    Page<TaskResponse> getAllTasks(
            Pageable pageable);

    TaskResponse getTaskById(
            String taskId);
}