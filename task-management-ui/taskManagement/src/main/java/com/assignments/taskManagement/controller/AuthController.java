package com.assignments.taskManagement.controller;

import com.assignments.taskManagement.dto.request.LoginRequest;
import com.assignments.taskManagement.dto.request.RegisterRequest;
import com.assignments.taskManagement.dto.response.UserResponse;
import com.assignments.taskManagement.security.AuthenticationService;
import com.assignments.taskManagement.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody @Valid RegisterRequest request) {

        return ResponseEntity.ok(
                userService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request, HttpServletRequest httpServletRequest) {

        authenticationService.login(request, httpServletRequest);

        return ResponseEntity.ok("Login successful");
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(
            HttpServletRequest request) {

        authenticationService.logout(request);

        return ResponseEntity.ok(
                "Logged out successfully");
    }
}