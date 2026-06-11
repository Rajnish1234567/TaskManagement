package com.assignments.taskManagement.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {

    private SecurityUtil() {}

    public static CustomUserDetails getCurrentUser() {

        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        return (CustomUserDetails)
                authentication.getPrincipal();
    }

    public static String getCurrentUserId() {

        return getCurrentUser()
                .getUser()
                .getId();
    }

    public static String getCurrentUserEmail() {

        return getCurrentUser()
                .getUser()
                .getEmail();
    }

    public static String getCurrentUserName() {

        return getCurrentUser()
                .getUser()
                .getName();
    }
}