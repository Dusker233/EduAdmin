package com.example.software.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

import java.io.Serializable;

@Entity
@IdClass(TeacherEvaluationId.class)
public class TeacherEvaluation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String courseId;

    @Id
    private String userId;

    private String teacherScore;

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setTeacherScore(String teacherScore) {
        this.teacherScore = teacherScore;
    }

    public String getTeacherScore() {
        return teacherScore;
    }

    @Override
    public String toString() {
        return "TeacherEvaluation{" +
                "courseId=" + courseId + '\'' +
                "userId=" + userId + '\'' +
                "teacherScore=" + teacherScore + '\'' +
                '}';
    }
}
