package com.example.software.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "exam_application")
public class ExamApplication {

    @Id
    @Column(name = "exam_id", nullable = false)
    private String examId;
    @Column(name = "exam_name", nullable = false)
    private String examName;
    @Column(name = "free_time", nullable = false)
    private String freeTime;

    @Column(name = "exam_format", nullable = false)
    private String examFormat;

    @Column(name = "classroom_id", nullable = false)
    private String classroomId;

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(String freeTime) {
        this.freeTime = freeTime;
    }

    public String getExamFormat() {
        return examFormat;
    }

    public void setExamFormat(String examFormat) {
        this.examFormat = examFormat;
    }

    public String getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(String classroomId) {
        this.classroomId = classroomId;
    }
}
