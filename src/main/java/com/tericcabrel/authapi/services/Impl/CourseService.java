package com.tericcabrel.authapi.services.Impl;

import com.tericcabrel.authapi.dtos.CourseWithLessonsDTO;
import com.tericcabrel.authapi.dtos.payloads.Result;
import com.tericcabrel.authapi.entities.Course;
import com.tericcabrel.authapi.entities.Lesson;
import com.tericcabrel.authapi.repositories.CourseRepository;
import com.tericcabrel.authapi.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private LessonRepository lessonRepository;

    public List<Course> searchCoursesByName(String courseName) {
        return courseRepository.findByTitleContainingIgnoreCase(courseName);
    }

    public Result<List<Course>> searchByCourseNameOrDescriptionOrInstructorName(String searchTerm) {
        var result = new Result();

        result.setData(courseRepository.searchByCourseNameOrDescriptionOrInstructorName(searchTerm));
        return result;
    }

    public Result<CourseWithLessonsDTO> getCourseWithLessons(Long courseId) {
        var result = new Result();
        Optional<Course> course = courseRepository.findById(courseId);

        if (course.isPresent()) {
            // Fetch all lessons for the course
            List<Lesson> lessons = lessonRepository.findByCourseId(courseId);
            result.setData(new CourseWithLessonsDTO(course.get(), lessons));
            return result;
        }
        return result;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
