package com.assignments.taskManagement.repository;

import com.assignments.taskManagement.entity.Task;
import com.assignments.taskManagement.enums.TaskStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository
        extends MongoRepository<Task, String> {

    Page<Task> findByUserId(
            String userId,
            Pageable pageable);

    long countByStatus(
            TaskStatus status);

    Page<Task> findByStatus(
            TaskStatus status,
            Pageable pageable);

    Page<Task> findByUserIdAndStatus(
            String userId,
            TaskStatus status,
            Pageable pageable);
}