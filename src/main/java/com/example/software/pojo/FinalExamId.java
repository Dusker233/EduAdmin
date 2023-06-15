package com.example.software.pojo;

import jakarta.persistence.Column;

import java.io.Serializable;

public class FinalExamId implements Serializable {
    @Column(name = "exam_id", nullable = false, length = 20)
    private String examId;
    @Column(name = "classroom_id", length = 20)
    private String classroomId;
    @Column(name = "exam_time", nullable = false, length = 20)
    private String examTime;

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(String classroomId) {
        this.classroomId = classroomId;
    }
}
