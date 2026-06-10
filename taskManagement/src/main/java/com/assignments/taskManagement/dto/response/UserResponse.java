package com.assignments.taskManagement.dto.response;

import com.assignments.taskManagement.enums.Role;
import com.assignments.taskManagement.enums.UserStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {

    private String id;

    private String name;

    private String email;

    private Role role;

    private UserStatus status;
}