package com.example.software.repository;

import com.example.software.pojo.CourseApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseApplicationRepository extends JpaRepository<CourseApplication, String> {
    @Query("select c from CourseApplication c")
    List<CourseApplication> getCourseApplicationList();
}
