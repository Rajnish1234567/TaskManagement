package com.assignments.taskManagement.dto.request;

import com.assignments.taskManagement.enums.UserStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserStatusUpdateRequest {

    @NotNull(message = "Status is required")
    private UserStatus status;
}