package com.tericcabrel.authapi.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "submissions")
@Data
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private User student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignment_id", nullable = false)
    private Assignment assignment;

    @Column(nullable = false)
    private String fileUrl;  // URL to the submission file

    @Column(nullable = false)
    private LocalDateTime submissionDate;

    @Column(precision = 3, scale = 2)
    private Double grade;  // Grade given to the submission

    @Lob
    private String feedback;  // Instructor feedback

    // Getters and Setters
}
