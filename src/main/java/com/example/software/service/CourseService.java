package com.example.software.service;

import com.example.software.pojo.Course;
import com.example.software.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getCourseList() {
        return courseRepository.getCourseList();
    }
}
