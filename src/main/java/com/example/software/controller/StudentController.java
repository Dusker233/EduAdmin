package com.example.software.controller;

import com.example.software.Utils;
import com.example.software.pojo.TeacherEvaluation;
import com.example.software.repository.*;
import com.example.software.response.Response;
import com.example.software.service.CourseService;
import com.example.software.service.StudentCoursesService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping(path = "/student")
public class StudentController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ClassroomRepository classroomRepository;
    @Autowired
    private StudentInfoRepository studentInfoRepository;
    @Autowired
    private ProgramsRepository programsRepository;
    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private StudentCoursesRepository studentCoursesRepository;
    @Autowired
    private TeacherEvaluationRepository teacherEvaluationRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    HttpSession httpSession;

    // 选课课程表查询
    @GetMapping("/courses")
    public Response getCourses() {
        if (httpSession.getAttribute("user") == null)
            return new Response(false, "未登录", null);
        try {
            var courses = studentCoursesRepository.findByStudentId((String) httpSession.getAttribute("user"));
            return new Response(true, "", courses.stream().map(StudentCoursesService::toDTO).collect(Collectors.toList()));
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false, "服务器错误", null);
        }
    }

    // 空闲教室查询
    @GetMapping("/classroom")
    public Response getClassroom() {
        try {
            return new Response(true, "", classroomRepository.findAll().stream().filter(it -> it.getFreeNow() == 1).map(Utils::toDTO).collect(Collectors.toList()));
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false, "服务器错误", null);
        }
    }

    // 成绩查询
    @GetMapping("/score")
    public Response getScore() {
        if (httpSession.getAttribute("user") == null)
            return new Response(false, "未登录", null);
        try {
            return new Response(true, "", scoreRepository.findByUserId((String) httpSession.getAttribute("user")).stream().map(Utils::toDTO).collect(Collectors.toList()));
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false, "服务器错误", null);
        }
    }

    /**
     * 评教信息获取。返回未评教的课程列表
     */
    @GetMapping("/evaluation")
    public Response getEvaluation() {
        if (httpSession.getAttribute("user") == null)
            return new Response(false, "未登录", null);
        try {
            var user = (String) httpSession.getAttribute("user");
            var evaluation = teacherEvaluationRepository.findByUserId(user);
            var courses = studentCoursesRepository.findByStudentId(user).stream().filter(
                    a -> evaluation.stream().noneMatch(
                            b -> a.getCourseId().equals(b.getCourseId())
                    )
            ).map(it -> CourseService.toDTO(courseRepository.getReferenceById(it.getCourseId())));
            return new Response(true, "", courses);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false, "服务器错误", null);
        }
    }
    @PostMapping("/set_evaluation")
    public Response setEvaluation(@RequestParam String courseId, @RequestParam String score) {
        if (httpSession.getAttribute("user") == null)
            return new Response(false, "未登录", null);
        try {
            var user = (String) httpSession.getAttribute("user");
            var evaluation = new TeacherEvaluation();
            evaluation.setCourseId(courseId);
            evaluation.setUserId(user);
            evaluation.setTeacherScore(score);
            teacherEvaluationRepository.save(evaluation);
            return new Response(true, "", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false, "服务器错误", null);
        }
    }
}
