package com.example.software.repository;

import com.example.software.pojo.ExamApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamApplicationRepository extends JpaRepository<ExamApplication, String> {
}
