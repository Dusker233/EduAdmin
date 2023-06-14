package com.example.software.service;

import com.example.software.dto.FinalExamDTO;
import com.example.software.pojo.FinalExam;
import com.example.software.repository.FinalExamRepository;
import com.example.software.vo.FinalExamVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class FinalExamService {

    @Autowired
    private FinalExamRepository finalExamRepository;

    public String save(FinalExamVO vO) {
        FinalExam bean = new FinalExam();
        BeanUtils.copyProperties(vO, bean);
        bean = finalExamRepository.save(bean);
        return bean.getExamId();
    }

    public void delete(String id) {
        finalExamRepository.deleteById(id);
    }

    public void update(String id, FinalExamVO vO) {
        FinalExam bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        finalExamRepository.save(bean);
    }

    public FinalExamDTO getById(String id) {
        FinalExam original = requireOne(id);
        return toDTO(original);
    }

    public Page<FinalExamDTO> query(FinalExamVO vO) {
        throw new UnsupportedOperationException();
    }

    private FinalExamDTO toDTO(FinalExam original) {
        FinalExamDTO bean = new FinalExamDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private FinalExam requireOne(String id) {
        return finalExamRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
