package com.assignments.taskManagement.service;

import com.assignments.taskManagement.dto.request.RegisterRequest;
import com.assignments.taskManagement.dto.request.UserStatusUpdateRequest;
import com.assignments.taskManagement.dto.response.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserResponse register(
            RegisterRequest request);

    Page<UserResponse> getAllUsers(
            Pageable pageable);

    UserResponse getUserById(
            String id);

    void deleteUser(
            String id);

    UserResponse updateUserStatus(
            String id,
            UserStatusUpdateRequest request);
}