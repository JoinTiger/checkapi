package com.example.demo.repository;

import com.example.demo.bean.Motor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MotorRepository extends JpaRepository<Motor, Long> {
    public List<Motor> findByProductId(Long id);
}
