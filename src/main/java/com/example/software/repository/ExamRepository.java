package com.example.software.repository;

import com.example.software.pojo.ExamApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExamRepository extends JpaRepository<ExamApplication, String> {
    @Query("select e from ExamApplication e where e.examId = ?1")
    ExamApplication getExamApplicationByExamId(String examId);
}
