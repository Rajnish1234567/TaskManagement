package com.assignments.taskManagement.controller;

import com.assignments.taskManagement.dto.response.ActivityResponse;
import com.assignments.taskManagement.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/activity-logs")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    @GetMapping
    public ResponseEntity<Page<ActivityResponse>> getLogs(Pageable pageable) {

        return ResponseEntity.ok(
                activityService.getAllLogs(pageable));
    }
}