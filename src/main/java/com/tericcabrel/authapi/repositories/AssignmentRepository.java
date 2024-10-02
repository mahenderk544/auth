package com.tericcabrel.authapi.repositories;

import com.tericcabrel.authapi.entities.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
}
