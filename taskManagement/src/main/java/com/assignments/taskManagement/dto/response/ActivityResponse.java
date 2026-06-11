package com.assignments.taskManagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityResponse {

    private String id;

    private String userId;

    private String userEmail;

    private String action;

    private String details;

    private Instant createdDate;
}