package com.assignments.taskManagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.Builder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboardResponse {

    private long totalUsers;

    private long totalTasks;

    private long completedTasks;

    private long pendingTasks;
}