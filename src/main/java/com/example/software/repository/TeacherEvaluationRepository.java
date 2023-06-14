package com.example.software.repository;

import com.example.software.pojo.TeacherEvaluation;
import com.example.software.pojo.TeacherEvaluationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TeacherEvaluationRepository extends JpaRepository<TeacherEvaluation, TeacherEvaluationId>, JpaSpecificationExecutor<TeacherEvaluation> {
    List<TeacherEvaluation> findByUserId(String userId);
}