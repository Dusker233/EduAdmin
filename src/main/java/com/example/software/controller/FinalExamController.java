package com.example.software.controller;

import com.example.software.pojo.Classroom;
import com.example.software.pojo.ExamApplication;
import com.example.software.pojo.FinalExam;
import com.example.software.response.Response;
import com.example.software.service.ClassroomService;
import com.example.software.service.ExamService;
import com.example.software.service.FinalExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin
@RequestMapping("/finalExam")
public class FinalExamController {
    @Autowired
    private ClassroomService classroomService;
    @Autowired
    private FinalExamService finalExamService;
    @Autowired
    private ExamService examService;

    @PostMapping("/arrange")
    public synchronized Response arrange() {
        List<ExamApplication> examList = examService.getExamList();
        List<Classroom> classroomList = classroomService.getClassroomList();
        Random random = new Random();
        while(!classroomList.isEmpty() && !examList.isEmpty()) {
            int tmpIndex = random.nextInt(classroomList.size());
            Classroom classroom = classroomList.get(tmpIndex);
            ExamApplication exam = examList.get(0);
            if(classroom.getFreeNow().equals(1)) {
                FinalExam finalExam = new FinalExam();
                finalExam.setExamId(exam.getExamId());
                finalExam.setMajorId(exam.getMajorId());
                finalExam.setExamTime(classroom.getFreeTime());
                finalExam.setClassroomId(classroom.getClassroomId());
                finalExam.setExamFormat(exam.getExamFormat());
                finalExamService.saveFinalExam(finalExam);

                classroomService.updateFreeNowToZeroByClassroomId(classroom.getClassroomId());
                classroomList.remove(tmpIndex);
                examList.remove(0);
            }
        }
        return new Response(true, "", null);
    }
}
