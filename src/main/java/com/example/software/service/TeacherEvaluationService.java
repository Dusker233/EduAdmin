package com.example.software.service;

import com.example.software.pojo.TeacherEvaluation;
import com.example.software.repository.TeacherEvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherEvaluationService {
    @Autowired
    private TeacherEvaluationRepository teacherEvaluationRepository;

    public void setTeacherEvaluationRepository(TeacherEvaluationRepository teacherEvaluationRepository) {
        this.teacherEvaluationRepository = teacherEvaluationRepository;
    }

    public List<TeacherEvaluation> getTeacherEvaluationsByUserId(String userId) {
        return teacherEvaluationRepository.getTeacherEvaluationsByUserId(userId);
    }


}
