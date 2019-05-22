package com.example.demo.repository;

import com.example.demo.bean.NcVer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NcVerRepository extends JpaRepository<NcVer, Long> {

    public NcVer findFirstByProductId(Long id);
}
