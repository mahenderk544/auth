package com.tericcabrel.authapi.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "quiz_options")
@Data
public class QuizOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String optionText;

    @Column(nullable = false)
    private Boolean isCorrect = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private QuizQuestion question;

    // Getters and Setters
}
