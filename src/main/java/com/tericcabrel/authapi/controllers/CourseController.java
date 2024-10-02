package com.tericcabrel.authapi.controllers;

import com.tericcabrel.authapi.dtos.CourseWithLessonsDTO;
import com.tericcabrel.authapi.dtos.payloads.Result;
import com.tericcabrel.authapi.entities.Course;
import com.tericcabrel.authapi.services.Impl.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController extends  BaseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/search")
    public List<Course> searchCourses(@RequestParam String name) {

        return courseService.searchCoursesByName(name);
    }

    @GetMapping("/search")
    public ResponseEntity<Result<List<Course>>> searchByCourseNameOrDescriptionOrInstructorName(@RequestParam String term) {
       var result =  courseService.searchByCourseNameOrDescriptionOrInstructorName(term);
        return  handleResult(result);
    }

    @GetMapping("/{id}/with-lessons")
    public ResponseEntity<Result<CourseWithLessonsDTO>> getCourseWithLessons(@PathVariable Long id) {
        var result =  courseService.getCourseWithLessons(id);
        return  handleResult(result);
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
