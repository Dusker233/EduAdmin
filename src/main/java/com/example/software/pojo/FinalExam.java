package com.example.software.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class FinalExam implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String examId;

    private String examName;

    private String freeTime;

    private String examFormat;

    private String classroomId;

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamName() {
        return examName;
    }

    public void setFreeTime(String freeTime) {
        this.freeTime = freeTime;
    }

    public String getFreeTime() {
        return freeTime;
    }

    public void setExamFormat(String examFormat) {
        this.examFormat = examFormat;
    }

    public String getExamFormat() {
        return examFormat;
    }

    public void setClassroomId(String classroomId) {
        this.classroomId = classroomId;
    }

    public String getClassroomId() {
        return classroomId;
    }

    @Override
    public String toString() {
        return "FinalExam{" +
                "examId=" + examId + '\'' +
                "examName=" + examName + '\'' +
                "freeTime=" + freeTime + '\'' +
                "examFormat=" + examFormat + '\'' +
                "classroomId=" + classroomId + '\'' +
                '}';
    }
}
