package com.assignments.taskManagement.dto.response;

import com.assignments.taskManagement.enums.TaskStatus;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class TaskResponse {

    private String id;

    private String title;

    private String description;

    private TaskStatus status;

    private String userId;

    private String userName;

    private String userEmail;

    private Instant createdDate;

    private Instant lastModifiedDate;
}