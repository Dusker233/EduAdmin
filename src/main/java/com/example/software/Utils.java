package com.example.software;

import com.example.software.dto.ClassroomDTO;
import com.example.software.dto.ScoreDTO;
import com.example.software.pojo.Classroom;
import com.example.software.pojo.Score;
import org.springframework.beans.BeanUtils;

public class Utils {

    public static ClassroomDTO toDTO(Classroom original) {
        ClassroomDTO bean = new ClassroomDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    public static ScoreDTO toDTO(Score original) {
        ScoreDTO bean = new ScoreDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }
}
