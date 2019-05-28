package com.example.demo.service;

import com.example.demo.bean.result.ElecAtrribueSummary;
import com.example.demo.repository.MotorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MotorService {

    @Autowired
    private MotorRepository motorRepository;

    @Transactional
    public List<ElecAtrribueSummary> findAtrributeByElecModel(String elecModel) {
        return motorRepository.findAtrributeByElecModel(elecModel);
    }

}
