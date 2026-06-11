package com.assignments.taskManagement.service.impl;

import com.assignments.taskManagement.dto.response.DashboardResponse;
import com.assignments.taskManagement.enums.TaskStatus;
import com.assignments.taskManagement.repository.TaskRepository;
import com.assignments.taskManagement.repository.UserRepository;
import com.assignments.taskManagement.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    @Override
    public DashboardResponse getDashboard() {

        long totalUsers = userRepository.count();

        long totalTasks = taskRepository.count();

        long completedTasks =
                taskRepository.countByStatus(
                        TaskStatus.COMPLETED);

        long pendingTasks =
                taskRepository.countByStatus(
                        TaskStatus.PENDING);

        return DashboardResponse.builder()
                .totalUsers(totalUsers)
                .totalTasks(totalTasks)
                .completedTasks(completedTasks)
                .pendingTasks(pendingTasks)
                .build();
    }
}