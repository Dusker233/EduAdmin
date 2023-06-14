package com.example.software.repository;

import com.example.software.pojo.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentInfoRepository extends JpaRepository<StudentInfo, String>, JpaSpecificationExecutor<StudentInfo> {

}