package com.tericcabrel.authapi.repositories;

import com.tericcabrel.authapi.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByTitleContainingIgnoreCase(String title);


    @Query("SELECT c FROM Course c JOIN c.instructor i WHERE " +
            "LOWER(c.title) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(c.description) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(i.name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    List<Course> searchByCourseNameOrDescriptionOrInstructorName(@Param("searchTerm") String searchTerm);
}
