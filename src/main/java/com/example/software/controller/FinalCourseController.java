package com.example.software.controller;

import com.example.software.service.FinalCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(path = "finalCourse")
public class FinalCourseController {
    @Autowired
    private FinalCourseService finalCourseService;

    public void setFinalCourseService(FinalCourseService finalCourseService) {
        this.finalCourseService = finalCourseService;
    }
}
