package com.example.software.repository;

import com.example.software.pojo.CourseApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseApplicationRepository extends JpaRepository<CourseApplication, String> {
}
