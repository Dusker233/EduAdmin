package com.example.software.repository;

import com.example.software.pojo.FinalCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinalCourseRepository extends JpaRepository<FinalCourse, String> {
}
