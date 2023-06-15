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

import java.util.*;

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
    Random random = new Random();

    @PostMapping("/arrange")
    public synchronized Response arrange() {
        Map<String, Set<String>> mapForNotAvailableMajorTime = new HashMap<>();
        List<ExamApplication> examList = examService.getExamList();
        List<Classroom> classroomList = classroomService.getClassroomList();
        while(!classroomList.isEmpty() && !examList.isEmpty()) {
            int tmpIndex = random.nextInt(classroomList.size());
            Classroom classroom = classroomList.get(tmpIndex);
            ExamApplication exam = examList.get(0);
            String majorId = exam.getMajorId();
            if(!mapForNotAvailableMajorTime.containsKey(majorId)) {
                mapForNotAvailableMajorTime.put(majorId, new HashSet<>());
            }
            Set<String> notAvailableTime = mapForNotAvailableMajorTime.get(majorId);
            while(notAvailableTime.contains(classroom.getFreeTime())) {
                tmpIndex = random.nextInt(classroomList.size());
                classroom = classroomList.get(tmpIndex);
            }
            if(classroom.getFreeNow().equals(1)) {
                FinalExam finalExam = new FinalExam();
                finalExam.setExamId(exam.getExamId());
                finalExam.setMajorId(exam.getMajorId());
                finalExam.setExamTime(classroom.getFreeTime());
                finalExam.setClassroomId(classroom.getClassroomId());
                finalExam.setExamFormat(exam.getExamFormat());
                finalExamService.saveFinalExam(finalExam);
                classroomService.updateFreeNowToZeroByClassroomIdAndClassroomFreeTime(classroom.getClassroomId(), classroom.getFreeTime());
                mapForNotAvailableMajorTime.get(majorId).add(classroom.getFreeTime());
                classroomList.remove(tmpIndex);
                examList.remove(0);
            }
        }
        return new Response(true, "", null);
    }
}
