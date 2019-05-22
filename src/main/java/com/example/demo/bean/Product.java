package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Product")
public class Product implements Serializable {

    private static final long serialVersionUID = 4963359130561432864L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @JsonIgnore
    private String batchId;

    private Long uploadTime;

    private Integer version;

    private Integer macAxNum;

    private String macModel;

    private String macNO;

    private String macSN;

    private String ipcCode;

    private String contractCode;

    private String customerName;

    private String loginName;

    @Transient
    private NcVer ncVer;

    @Transient
    private List<Servo> servos = new ArrayList<>();

    @Transient
    private List<Motor> motors = new ArrayList<>();



    public Product() {
    }

    public Product(String batchId, Long uploadTime, Integer version, Integer macAxNum, String macModel, String macNO, String macSN, String ipcCode, String contractCode, String customerName, String loginName, NcVer ncVer, List<Servo> servos, List<Motor> motors) {
        this.batchId = batchId;
        this.uploadTime = uploadTime;
        this.version = version;
        this.macAxNum = macAxNum;
        this.macModel = macModel;
        this.macNO = macNO;
        this.macSN = macSN;
        this.ipcCode = ipcCode;
        this.contractCode = contractCode;
        this.customerName = customerName;
        this.loginName = loginName;
        this.ncVer = ncVer;
        this.servos = servos;
        this.motors = motors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public Long getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Long uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getMacAxNum() {
        return macAxNum;
    }

    public void setMacAxNum(Integer macAxNum) {
        this.macAxNum = macAxNum;
    }

    public String getMacModel() {
        return macModel;
    }

    public void setMacModel(String macModel) {
        this.macModel = macModel;
    }

    public String getMacNO() {
        return macNO;
    }

    public void setMacNO(String macNO) {
        this.macNO = macNO;
    }

    public String getMacSN() {
        return macSN;
    }

    public void setMacSN(String macSN) {
        this.macSN = macSN;
    }

    public String getIpcCode() {
        return ipcCode;
    }

    public void setIpcCode(String ipcCode) {
        this.ipcCode = ipcCode;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public NcVer getNcVer() {
        return ncVer;
    }

    public void setNcVer(NcVer ncVer) {
        this.ncVer = ncVer;
    }

    public List<Servo> getServos() {
        return servos;
    }

    public void setServos(List<Servo> servos) {
        this.servos = servos;
    }

    public List<Motor> getMotors() {
        return motors;
    }

    public void setMotors(List<Motor> motors) {
        this.motors = motors;
    }
}
