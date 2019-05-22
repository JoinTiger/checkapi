package com.example.demo.repository;

import com.example.demo.bean.Servo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServoRepository extends JpaRepository<Servo, Long> {

    public List<Servo> findByProductId(Long id);


}
