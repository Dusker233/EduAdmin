package com.example.software.repository;

import com.example.software.pojo.StudentCourses;
import com.example.software.pojo.StudentCoursesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface StudentCoursesRepository extends JpaRepository<StudentCourses, StudentCoursesId>, JpaSpecificationExecutor<StudentCourses> {
    List<StudentCourses> findByStudentId(String studentId);

}