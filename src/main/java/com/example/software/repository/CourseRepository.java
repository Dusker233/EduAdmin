package com.example.software.repository;

import com.example.software.pojo.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

    @Query("select c from Course c")
    List<Course> getCourseList();

    @Query("select c from Course c where c.courseId = ?1")
    Course getCourseByCourseId(String courseId);
}
