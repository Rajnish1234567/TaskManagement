package com.assignments.taskManagement.dto.response;

import com.assignments.taskManagement.enums.TaskStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TaskResponse {

    private String id;

    private String title;

    private String description;

    private TaskStatus status;

    private String userId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}