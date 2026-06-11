package com.assignments.taskManagement.controller;

import com.assignments.taskManagement.dto.request.TaskCreateRequest;
import com.assignments.taskManagement.dto.request.TaskUpdateRequest;
import com.assignments.taskManagement.dto.response.TaskResponse;
import com.assignments.taskManagement.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@RequestBody @Valid TaskCreateRequest request) {

        return ResponseEntity.ok(
                taskService.createTask(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> updateTask(@PathVariable String id, @RequestBody TaskUpdateRequest request) {

        return ResponseEntity.ok(
                taskService.updateTask(
                        id,
                        request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable String id) {

        taskService.deleteTask(id);
        return ResponseEntity.noContent()
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getTask(@PathVariable String id) {

        return ResponseEntity.ok(
                taskService.getTaskById(id));
    }

    @GetMapping("/my")
    public ResponseEntity<Page<TaskResponse>> getMyTasks(Pageable pageable) {

        return ResponseEntity.ok(
                taskService.getMyTasks(pageable));
    }

    @GetMapping
    public ResponseEntity<Page<TaskResponse>> getAllTasks(Pageable pageable) {

        return ResponseEntity.ok(
                taskService.getAllTasks(pageable));
    }
}