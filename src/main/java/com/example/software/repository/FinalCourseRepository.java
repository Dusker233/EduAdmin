package com.example.software.repository;

import com.example.software.pojo.FinalCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinalCourseRepository extends JpaRepository<FinalCourse, String> {
    @Query("select t from FinalCourse t where t.courseTeacherId = ?1")
    List<FinalCourse> getFinalCoursesByUserId(String userId);

    @Query("select f from FinalCourse f")
    List<FinalCourse> getFinalCourseList();
}
