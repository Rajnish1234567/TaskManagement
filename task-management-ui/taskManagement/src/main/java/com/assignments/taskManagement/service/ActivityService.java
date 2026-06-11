package com.assignments.taskManagement.service;

import com.assignments.taskManagement.dto.response.ActivityResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ActivityService {

    void logActivity(
            String action,
            String details);

    Page<ActivityResponse>
    getAllLogs(
            Pageable pageable);
}