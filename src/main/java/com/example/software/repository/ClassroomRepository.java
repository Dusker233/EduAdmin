package com.example.software.repository;

import com.example.software.pojo.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, String> {

    @Query("select c from Classroom c where c.freeNow = 1")
    List<Classroom> getClassroomList();

    @Transactional
    @Modifying
    @Query("update Classroom c set c.freeNow = 0 where c.classroomId = ?1")
    void updateFreeNowToZeroByClassroomId(String classroomId);

    @Query("select c from Classroom c where c.classroomId = ?1")
    Classroom getClassroomByClassroomId(String classroomId);
}
