package com.example.software.service;

import com.example.software.pojo.ExamApplication;
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

    public void applyExamByMajorCourseAndFormat(
            String examId,
            String majorId,
            String courseId,
            String examFormat){
        ExamApplication EA1 = new ExamApplication();
        EA1.setExamId(examId);
        EA1.setMajorId(majorId);
        EA1.setCourseId(courseId);
        EA1.setExamFormat(examFormat);
        ExamApplicationRepository.save(EA1);
    }
}
