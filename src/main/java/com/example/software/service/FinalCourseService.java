package com.example.software.service;

import com.example.software.dto.FinalCourseDTO;
import com.example.software.pojo.FinalCourse;
import com.example.software.repository.FinalCourseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinalCourseService {
    @Autowired
    private FinalCourseRepository finalCourseRepository;

    public void setFinalCourseRepository(FinalCourseRepository finalCourseRepository) {
        this.finalCourseRepository = finalCourseRepository;
    }

    public List<FinalCourse> getFinalCoursesByUserId(String userId){
        return finalCourseRepository.getFinalCoursesByUserId(userId);
    }
    public static FinalCourseDTO toDTO(FinalCourse original) {
        FinalCourseDTO bean = new FinalCourseDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    public void saveFinalCourse(FinalCourse finalCourse) {
        finalCourseRepository.save(finalCourse);
    }

    public List<FinalCourse> getFinalCourseList() {
        return finalCourseRepository.getFinalCourseList();
    }
}
