package com.assignments.taskManagement.dto.response;

import com.assignments.taskManagement.enums.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {

    private String userId;

    private String name;

    private String email;

    private Role role;

    private String sessionId;
}