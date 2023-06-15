package com.example.software.service;

import com.example.software.pojo.CourseApplication;
import com.example.software.pojo.CourseApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseApplicationService {
    @Autowired
    private CourseApplicationRepository courseApplicationRepository;

    public CourseApplication findById(String courseId) {
        return courseApplicationRepository.findById(courseId).orElse(null);
    }

    public boolean deleteCourseApplication(String courseId) {
        try {
            courseApplicationRepository.deleteById(courseId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
