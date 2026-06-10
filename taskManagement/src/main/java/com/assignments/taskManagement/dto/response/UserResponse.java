package com.assignments.taskManagement.dto.response;

import com.assignments.taskManagement.entity.Audit;
import com.assignments.taskManagement.enums.Role;
import com.assignments.taskManagement.enums.UserStatus;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
@Builder
public class UserResponse  {

    private String id;

    private String name;

    private String email;

    private Role role;

    private UserStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}