package com.example.software.service;

import com.example.software.pojo.Score;
import com.example.software.pojo.TeacherEvaluation;
import com.example.software.repository.ClassroomRepository;
import com.example.software.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository ScoreRepository;

    public void setScoreRepository(com.example.software.repository.ScoreRepository scoreRepository) {
        ScoreRepository = scoreRepository;
    }
    public void setScoreByUserIdAndCourseId(Integer score, String courseId, String userId){
        Score score1 = new Score();
        score1.setScore(score);
        score1.setUserId(userId);
        score1.setCourseId(courseId);
        ScoreRepository.save(score1);
    }
}