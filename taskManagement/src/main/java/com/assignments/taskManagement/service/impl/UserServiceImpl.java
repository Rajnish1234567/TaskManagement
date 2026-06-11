package com.assignments.taskManagement.service.impl;

import com.assignments.taskManagement.dto.request.RegisterRequest;
import com.assignments.taskManagement.dto.request.UserStatusUpdateRequest;
import com.assignments.taskManagement.dto.response.UserResponse;
import com.assignments.taskManagement.entity.User;
import com.assignments.taskManagement.enums.Role;
import com.assignments.taskManagement.enums.UserStatus;
import com.assignments.taskManagement.exception.ResourceNotFoundException;
import com.assignments.taskManagement.repository.UserRepository;
import com.assignments.taskManagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException(
                    "Email already exists");
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(
                        passwordEncoder.encode(
                                request.getPassword()))
                .role(Role.ROLE_USER)
                .status(UserStatus.ACTIVE)
                .build();

        User savedUser = userRepository.save(user);

        return mapToResponse(savedUser);
    }

    @Override
    public Page<UserResponse> getAllUsers(
            Pageable pageable) {

        return userRepository
                .findAll(pageable)
                .map(this::mapToResponse);
    }

    @Override
    public UserResponse getUserById(
            String userId) {

        User user = userRepository
                .findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found"));

        return mapToResponse(user);
    }

    @Override
    public UserResponse updateUserStatus(
            String userId,
            UserStatusUpdateRequest request) {

        User user = userRepository
                .findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found"));

        user.setStatus(request.getStatus());

        User updatedUser =
                userRepository.save(user);

        return mapToResponse(updatedUser);
    }

    @Override
    public void deleteUser(
            String userId) {

        User user = userRepository
                .findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found"));

        userRepository.delete(user);
    }

    private UserResponse mapToResponse(
            User user) {

        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .status(user.getStatus())
                .createdAt(user.getCreatedAt())
                .updatedAt(
                        user.getUpdatedAt())
                .build();
    }
}