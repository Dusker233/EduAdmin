package com.example.software.service;

import com.example.software.dto.CourseDTO;
import com.example.software.pojo.Course;
import com.example.software.repository.CourseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    public static CourseDTO toDTO(Course original) {
        CourseDTO bean = new CourseDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }
}
