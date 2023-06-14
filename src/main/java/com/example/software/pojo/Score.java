package com.example.software.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

import java.io.Serializable;

@Entity
@IdClass(ScoreId.class)
public class Score implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String userId;

    @Id
    private String courseId;

    private Integer score;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "userId=" + userId + '\'' +
                "courseId=" + courseId + '\'' +
                "score=" + score + '\'' +
                '}';
    }


}
