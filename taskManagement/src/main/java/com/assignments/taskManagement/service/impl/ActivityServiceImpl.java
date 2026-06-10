package com.assignments.taskManagement.service.impl;

import com.assignments.taskManagement.dto.response.ActivityResponse;
import com.assignments.taskManagement.entity.Activity;
import com.assignments.taskManagement.repository.ActivityRepository;
import com.assignments.taskManagement.security.SecurityUtil;
import com.assignments.taskManagement.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityLogRepository;

    @Override
    public void logActivity(
            String action,
            String details) {

        Activity log = Activity.builder()
                .userId(SecurityUtil.getCurrentUserId())
                .userEmail(SecurityUtil.getCurrentUserEmail())
                .action(action)
                .details(details)
                .build();

        activityLogRepository.save(log);
    }

    @Override
    public Page<ActivityResponse> getAllLogs(
            Pageable pageable) {

        return activityLogRepository
                .findAll(pageable)
                .map(this::mapToResponse);
    }

    private ActivityResponse mapToResponse(
            Activity log) {

        return ActivityResponse.builder()
                .id(log.getId())
                .userId(log.getUserId())
                .userEmail(log.getUserEmail())
                .action(log.getAction())
                .details(log.getDetails())
                .build();
    }
}