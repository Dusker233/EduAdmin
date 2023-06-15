package com.example.software.repository;

import com.example.software.pojo.Score;
import com.example.software.pojo.ScoreId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, ScoreId>, JpaSpecificationExecutor<Score> {
    List<Score> findByUserId(String userId);
}