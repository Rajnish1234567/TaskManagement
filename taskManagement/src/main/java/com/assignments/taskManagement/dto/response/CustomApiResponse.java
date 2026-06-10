package com.assignments.taskManagement.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomApiResponse<T> {

    private boolean success;

    private String message;

    private T data;
}