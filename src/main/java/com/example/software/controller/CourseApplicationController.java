package com.example.software.controller;

import com.example.software.response.Response;
import com.example.software.service.CourseApplicationService;
import com.example.software.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "/courseapplication")
public class CourseApplicationController {
    @Autowired
    private CourseApplicationService courseApplicationService;

//    public void setCourseService(CourseService courseService) {
//        this.courseService = courseService;
//    }

    public CourseApplicationController(CourseApplicationService courseApplicationService) {
        this.courseApplicationService = courseApplicationService;
    }

    @PostMapping(path = "/courseapplication")
    public synchronized Response courseapplication(
            @RequestParam String courseId,
            @RequestParam String courseName,
            @RequestParam String userId,
            @RequestParam Integer courseNum){
        courseApplicationService.applyCourseByCourseIdNameUserIdAndCourseNum(courseId, courseName, userId, courseNum);
        return new Response(true, "", null);
    }
}
