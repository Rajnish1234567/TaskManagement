package com.assignments.taskManagement.dto.response;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ActivityResponse{

    private String userEmail;

    private String action;

    private String details;

    private String ipAddress;

    private Long timestamp;
}