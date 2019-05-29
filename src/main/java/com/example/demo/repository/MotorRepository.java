package com.example.demo.repository;

import com.example.demo.bean.Motor;
import com.example.demo.bean.result.ElecAtrribueSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MotorRepository extends JpaRepository<Motor, Long> {
    public List<Motor> findByProductId(Long productId);

    @Query(value = "select elecModel, elecName as name, max(cur) as max, min(cur) as min, avg(cur) as average from motor" +
            " where 1 = 1 and if(isnull(?1) || length(trim(?1)) < 1, 1 = 0, elecModel = ?1)" +
            " group by elecName", nativeQuery = true)
    public List<ElecAtrribueSummary> findAtrributeByElecModel(String elecModel);
}
