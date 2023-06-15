package com.example.software.util;

import com.example.software.pojo.Classroom;
import com.example.software.repository.ClassroomRepository;
import com.example.software.service.ClassroomService;
import com.mifmif.common.regex.Generex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/init")
public class classroomInit {
    @Autowired
    private ClassroomRepository classroomRepository;
    @GetMapping("/initClassroom")
    public void init() {
        Generex generexName = new Generex("(图西教学楼|电子楼|文学楼|商学院) [1-2]0[1-5]");
        Generex generexTime = new Generex("(Mon|Tue|Wed|Thu|Fri),(08:00-09:50|10:10-12:00|14:30-16:20|16:40-18:30)");
        List<String> nameList = generexName.getAllMatchedStrings();
        List<String> timeList = generexTime.getAllMatchedStrings();
        int cnt = 0;
        for(int i = 0;i < nameList.size();i++) {
            for(int j = 0;j < timeList.size();j++) {
                Classroom classroom = new Classroom();
                classroom.setClassroomId(String.valueOf(5000 + cnt));
                classroom.setClassroomName(nameList.get(i));
                classroom.setFreeTime(timeList.get(j));
                classroom.setFreeNow(1);
                classroomRepository.save(classroom);
                cnt++;
            }
        }
    }
}
