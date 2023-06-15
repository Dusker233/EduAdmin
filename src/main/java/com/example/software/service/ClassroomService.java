package com.example.software.service;

import com.example.software.dto.ClassroomDTO;
import com.example.software.pojo.Classroom;
import com.example.software.repository.ClassroomRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassroomService {
    @Autowired
    private ClassroomRepository classroomRepository;

    public void setClassroomRepository(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    public static ClassroomDTO toDTO(Classroom original) {
        ClassroomDTO bean = new ClassroomDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }
}
