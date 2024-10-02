package com.tericcabrel.authapi.dtos;

import com.tericcabrel.authapi.entities.Course;
import com.tericcabrel.authapi.entities.Lesson;
import lombok.Data;

import java.util.List;

@Data
public class CourseWithLessonsDTO {
    private Course course;
    private List<Lesson> lessons;

    public CourseWithLessonsDTO(Course course, List<Lesson> lessons) {
        this.course = course;
        this.lessons = lessons;
    }
}
