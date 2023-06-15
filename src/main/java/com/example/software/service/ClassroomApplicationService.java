package com.example.software.service;

import com.example.software.pojo.ClassroomApplication;
import com.example.software.repository.ClassroomApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomApplicationService {
    @Autowired
    private ClassroomApplicationRepository classroomApplicationRepository;

    public List<ClassroomApplication> listApplication() {
        return classroomApplicationRepository.findAll();
    }

    public void deleteApplicationByUserIdAndClassroomIdAndNeedTime(String userId, String classroomId, String needTime) {
        classroomApplicationRepository.deleteApplicationByUserIdAndClassroomIdAndNeedTime(userId, classroomId, needTime);
    }
}
