package com.example.software.service;

import com.example.software.pojo.FinalExam;
import com.example.software.repository.FinalExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinalExamService {
    @Autowired
    private FinalExamRepository finalExamRepository;

    public void setFinalExamRepository(FinalExamRepository finalExamRepository) {
        this.finalExamRepository = finalExamRepository;
    }

    public void saveFinalExam(FinalExam finalExam) {
        finalExamRepository.save(finalExam);
    }
}
