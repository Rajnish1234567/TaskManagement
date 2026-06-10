package com.assignments.taskManagement.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "activity_logs")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Activity {

    @Id
    private String id;

    private String userId;

    private String userEmail;

    private String action;

    private String details;

    private String ipAddress;

    private Long timestamp;
}