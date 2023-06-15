package com.example.software.repository;

import com.example.software.pojo.FinalExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FinalExamRepository extends JpaRepository<FinalExam, String> {

    @Query("select count(1) from FinalExam e")
    int countFinalExams();
}
