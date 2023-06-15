package com.example.software.service;

import com.example.software.pojo.CourseApplication;
import com.example.software.repository.CourseApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseApplicationService {
    @Autowired
    private CourseApplicationRepository courseApplicationRepository;

    public CourseApplication findById(String courseId) {
        return courseApplicationRepository.findById(courseId).orElse(null);
    }
    public void setCourseApplicationRepository(CourseApplicationRepository courseApplicationRepository) {
        this.courseApplicationRepository = courseApplicationRepository;
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

    public void applyCourseByCourseIdNameUserIdAndCourseNum(
            String courseId,
            String courseName,
            String userId,
            Integer courseNum){
        CourseApplication courseA1 = new CourseApplication();
        courseA1.setCourseId(courseId);
        courseA1.setCourseName(courseName);
        courseA1.setCourseTeacherId(userId);
        courseA1.setCourseNum(courseNum);
        courseApplicationRepository.save(courseA1);
    }
}
