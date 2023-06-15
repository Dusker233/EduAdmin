package com.example.software.service;

import com.example.software.pojo.ExamApplication;
import com.example.software.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {
    @Autowired
    private ExamRepository examRepository;

    public void setExamRepository(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public List<ExamApplication> getExamList() {
        return examRepository.findAll();
    }
}
