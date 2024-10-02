package com.tericcabrel.authapi.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "progress")
@Data
public class Progress {

    @EmbeddedId
    private ProgressId id;

    @Column(nullable = false)
    private Double progressPercentage;

    @Column(nullable = false)
    private LocalDateTime lastAccessed;

    // Composite Key for Progress Table
    @Embeddable
    @Data
    public static class ProgressId implements java.io.Serializable {
        @Column(name = "student_id")
        private Long studentId;

        @Column(name = "course_id")
        private Long courseId;

        @Column(name = "lesson_id")
        private Long lessonId;

        // Constructors, Getters, Setters, hashCode, and equals
    }

    // Getters and Setters
}
