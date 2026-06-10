package com.assignments.taskManagement.entity;

import com.assignments.taskManagement.enums.TaskStatus;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task extends Audit {

    @Id
    private String id;

    private String title;

    private String description;

    private TaskStatus status;

    private String userId;

    private String userName;

}


//
//├── repository
//
//├── service
//
//├── controller
//
//├── security
//
//├── exception
//│   ├── GlobalExceptionHandler
//│   ├── ResourceNotFoundException
//│   └── UnauthorizedException
//
//├── aspect
//│   ├── TrackActivity
//│   └── ActivityLogAspect
//
//├── util
//
//└── TaskManagementApplication