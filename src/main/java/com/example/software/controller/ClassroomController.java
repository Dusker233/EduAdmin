package com.example.software.controller;

import com.example.software.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(path = "/classroom")
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;

    public void setClassroomService(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }
}
