package com.example.software.controller;

import com.example.software.pojo.Classroom;
import com.example.software.pojo.Course;
import com.example.software.pojo.FinalCourse;
import com.example.software.response.Response;
import com.example.software.service.ClassroomService;
import com.example.software.service.CourseService;
import com.example.software.service.FinalCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin
@RequestMapping(path = "/finalCourse")
public class FinalCourseController {
    @Autowired
    private FinalCourseService finalCourseService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private ClassroomService classroomService;

    public FinalCourseController(FinalCourseService finalCourseService) {
        this.finalCourseService = finalCourseService;
    }

    @PostMapping(path = "/arrange")
    public Response arrange() {

        List<Course> courseList = courseService.getCourseList();
        List<Classroom> classroomList = classroomService.getClassroomList();

        Random random = new Random();

        while (!classroomList.isEmpty() && !courseList.isEmpty()) {

            int tmpIndex = random.nextInt(classroomList.size());
            Classroom classroom = classroomList.get(tmpIndex);
            Course course = courseList.get(0);
            if(course.getCourseNum() <= 0) {
                courseList.remove(0);
                continue;
            }

            if (classroom.getFreeNow().equals(1)) {

                FinalCourse finalCourse = new FinalCourse();
                finalCourse.setCourseId(course.getCourseId());
                finalCourse.setCourseName(course.getCourseName());
                finalCourse.setCourseTeacherId(course.getCourseTeacherId());
                finalCourse.setClassroomId(classroom.getClassroomId());
                finalCourse.setClassroomName(classroom.getClassroomName());
                finalCourse.setFreeTime(classroom.getFreeTime());
                finalCourseService.saveFinalCourse(finalCourse);

                classroomService.updateFreeNowToZeroByClassroomId(classroom.getClassroomId());
                classroomList.remove(tmpIndex);
                course.setCourseNum(course.getCourseNum() - 1);
                courseList.remove(0);
                courseList.add(course);
            }

        }
        return new Response(true, "", null);
    }
}
