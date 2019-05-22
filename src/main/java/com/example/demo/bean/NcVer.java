package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "NcVer")
public class NcVer implements Serializable {

    private static final long serialVersionUID = -2761918922382521922L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    private String softVer;

    private String testSoftVer;

    private String ncuVer;

    private String testNcuVer;

    private String plcVer;

    private String testPlcVer;

    private String drvVer;

    private String testDrvVer;

    private String userParmVer;

    private String testUserParmVer;

    private String userPlcVer;

    private String testUserPlcVer;

    private String osVer;

    private String testOsVer;

    private String fpgaVer;

    private String testFpgaVer;

    @JsonIgnore
    private Long productId;

    public NcVer() {
    }

    public NcVer(String softVer, String testSoftVer, String ncuVer, String testNcuVer, String plcVer, String testPlcVer, String drvVer, String testDrvVer, String userParmVer, String testUserParmVer, String userPlcVer, String testUserPlcVer, String osVer, String testOsVer, String fpgaVer, String testFpgaVer, Long productId) {
        this.softVer = softVer;
        this.testSoftVer = testSoftVer;
        this.ncuVer = ncuVer;
        this.testNcuVer = testNcuVer;
        this.plcVer = plcVer;
        this.testPlcVer = testPlcVer;
        this.drvVer = drvVer;
        this.testDrvVer = testDrvVer;
        this.userParmVer = userParmVer;
        this.testUserParmVer = testUserParmVer;
        this.userPlcVer = userPlcVer;
        this.testUserPlcVer = testUserPlcVer;
        this.osVer = osVer;
        this.testOsVer = testOsVer;
        this.fpgaVer = fpgaVer;
        this.testFpgaVer = testFpgaVer;
        this.productId = productId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSoftVer() {
        return softVer;
    }

    public void setSoftVer(String softVer) {
        this.softVer = softVer;
    }

    public String getTestSoftVer() {
        return testSoftVer;
    }

    public void setTestSoftVer(String testSoftVer) {
        this.testSoftVer = testSoftVer;
    }

    public String getNcuVer() {
        return ncuVer;
    }

    public void setNcuVer(String ncuVer) {
        this.ncuVer = ncuVer;
    }

    public String getTestNcuVer() {
        return testNcuVer;
    }

    public void setTestNcuVer(String testNcuVer) {
        this.testNcuVer = testNcuVer;
    }

    public String getPlcVer() {
        return plcVer;
    }

    public void setPlcVer(String plcVer) {
        this.plcVer = plcVer;
    }

    public String getTestPlcVer() {
        return testPlcVer;
    }

    public void setTestPlcVer(String testPlcVer) {
        this.testPlcVer = testPlcVer;
    }

    public String getDrvVer() {
        return drvVer;
    }

    public void setDrvVer(String drvVer) {
        this.drvVer = drvVer;
    }

    public String getTestDrvVer() {
        return testDrvVer;
    }

    public void setTestDrvVer(String testDrvVer) {
        this.testDrvVer = testDrvVer;
    }

    public String getUserParmVer() {
        return userParmVer;
    }

    public void setUserParmVer(String userParmVer) {
        this.userParmVer = userParmVer;
    }

    public String getTestUserParmVer() {
        return testUserParmVer;
    }

    public void setTestUserParmVer(String testUserParmVer) {
        this.testUserParmVer = testUserParmVer;
    }

    public String getUserPlcVer() {
        return userPlcVer;
    }

    public void setUserPlcVer(String userPlcVer) {
        this.userPlcVer = userPlcVer;
    }

    public String getTestUserPlcVer() {
        return testUserPlcVer;
    }

    public void setTestUserPlcVer(String testUserPlcVer) {
        this.testUserPlcVer = testUserPlcVer;
    }

    public String getOsVer() {
        return osVer;
    }

    public void setOsVer(String osVer) {
        this.osVer = osVer;
    }

    public String getTestOsVer() {
        return testOsVer;
    }

    public void setTestOsVer(String testOsVer) {
        this.testOsVer = testOsVer;
    }

    public String getFpgaVer() {
        return fpgaVer;
    }

    public void setFpgaVer(String fpgaVer) {
        this.fpgaVer = fpgaVer;
    }

    public String getTestFpgaVer() {
        return testFpgaVer;
    }

    public void setTestFpgaVer(String testFpgaVer) {
        this.testFpgaVer = testFpgaVer;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
