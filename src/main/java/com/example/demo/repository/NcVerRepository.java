package com.example.demo.repository;

import com.example.demo.bean.NcVer;
import com.example.demo.bean.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NcVerRepository extends JpaRepository<NcVer, Long> {

    public NcVer findFirstByProductId(Long productId);


}
