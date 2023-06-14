package com.example.software.repository;

import com.example.software.pojo.FinalExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface FinalExamRepository extends JpaRepository<FinalExam, String>, JpaSpecificationExecutor<FinalExam> {
    List<FinalExam> findByExamName(String examName);
}