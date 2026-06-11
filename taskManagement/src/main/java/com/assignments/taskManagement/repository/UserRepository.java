package com.assignments.taskManagement.repository;

import com.assignments.taskManagement.entity.User;
import com.assignments.taskManagement.enums.Role;
import com.assignments.taskManagement.enums.UserStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository
        extends MongoRepository<User, String> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    long countByRole(Role role);

    long countByStatus(UserStatus status);
}