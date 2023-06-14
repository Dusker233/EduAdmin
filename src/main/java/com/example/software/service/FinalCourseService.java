package com.example.software.service;

import com.example.software.repository.FinalCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinalCourseService {
    @Autowired
    private FinalCourseRepository finalCourseRepository;

    public void setFinalCourseRepository(FinalCourseRepository finalCourseRepository) {
        this.finalCourseRepository = finalCourseRepository;
    }
}
