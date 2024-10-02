package com.tericcabrel.authapi.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "lessons")
@Data
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Lob
    private String content;  // Could be text or HTML content

    @Column
    private String videoUrl;  // Optional field for a lesson video

    @Column(nullable = false)
    private Integer position;  // Position within the course

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    // Getters and Setters
}
