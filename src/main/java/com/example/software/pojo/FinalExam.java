package com.example.software.pojo;

import jakarta.persistence.*;

@Entity
@Table(name = "final_exam")
@IdClass(FinalExamId.class)
public class FinalExam {
    @Id
    @Column(name = "exam_id", nullable = false, length = 20)
    private String examId;

    @Column(name = "major_id", nullable = false, length = 10)
    private String majorId;

    @Id
    @Column(name = "exam_time", nullable = false, length = 20)
    private String examTime;

    @Column(name = "exam_format", length = 10)
    private String examFormat;

    @Id
    @Column(name = "classroom_id", length = 20)
    private String classroomId;

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
        this.examTime = examTime;
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