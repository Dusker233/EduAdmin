package com.example.software.service;

import com.example.software.repository.ExamApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamApplicationService {
    @Autowired
    private ExamApplicationRepository ExamApplicationRepository;

    public void setExamApplicationRepository(com.example.software.repository.ExamApplicationRepository examApplicationRepository) {
        ExamApplicationRepository = examApplicationRepository;
    }
}
