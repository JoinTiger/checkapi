package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "servo")
public class Servo implements Serializable {

    private static final long serialVersionUID = 1031458297022846820L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    private String servoId;

    private String axisName;

    private String servoType;

    private String testServoType;

    private String servoVer;

    private String testServoVer;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date servoProductTime;

    @JsonIgnore
    private Long productId;

    public Servo() {
    }

    public Servo(String servoId, String axisName, String servoType, String testServoType, String servoVer, String testServoVer, Date servoProductTime, Long productId) {
        this.servoId = servoId;
        this.axisName = axisName;
        this.servoType = servoType;
        this.testServoType = testServoType;
        this.servoVer = servoVer;
        this.testServoVer = testServoVer;
        this.servoProductTime = servoProductTime;
        this.productId = productId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServoId() {
        return servoId;
    }

    public void setServoId(String servoId) {
        this.servoId = servoId;
    }

    public String getAxisName() {
        return axisName;
    }

    public void setAxisName(String axisName) {
        this.axisName = axisName;
    }

    public String getServoType() {
        return servoType;
    }

    public void setServoType(String servoType) {
        this.servoType = servoType;
    }

    public String getTestServoType() {
        return testServoType;
    }

    public void setTestServoType(String testServoType) {
        this.testServoType = testServoType;
    }

    public String getServoVer() {
        return servoVer;
    }

    public void setServoVer(String servoVer) {
        this.servoVer = servoVer;
    }

    public String getTestServoVer() {
        return testServoVer;
    }

    public void setTestServoVer(String testServoVer) {
        this.testServoVer = testServoVer;
    }

    public Date getServoProductTime() {
        return servoProductTime;
    }

    public void setServoProductTime(Date servoProductTime) {
        this.servoProductTime = servoProductTime;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
