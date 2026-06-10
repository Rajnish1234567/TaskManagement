package com.assignments.taskManagement.entity;

import com.assignments.taskManagement.enums.Role;
import com.assignments.taskManagement.enums.UserStatus;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends Audit {

    @Id
    private String id;

    private String name;

    private String email;

    private String password;

    private Role role;

    private UserStatus status;
}