package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Motor")
public class Motor implements Serializable {

    private static final long serialVersionUID = -6205709567774723142L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    private String axisName;

    private String servoId;

    private String elecId;

    private String servoModel;

    private String elecModel;

    /**
     * 值为 accTime、accElecFF...
     */
    private String elecName;

    private Double min;

    private Double max;

    private Double average;

    private Double cur;

    @JsonIgnore
    private Long productId;

    public Motor() {
    }

    public Motor(String axisName, String servoId, String elecId, String servoModel, String elecModel, String elecName, Double min, Double max, Double average, Double cur, Long productId) {
        this.axisName = axisName;
        this.servoId = servoId;
        this.elecId = elecId;
        this.servoModel = servoModel;
        this.elecModel = elecModel;
        this.elecName = elecName;
        this.min = min;
        this.max = max;
        this.average = average;
        this.cur = cur;
        this.productId = productId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAxisName() {
        return axisName;
    }

    public void setAxisName(String axisName) {
        this.axisName = axisName;
    }

    public String getServoId() {
        return servoId;
    }

    public void setServoId(String servoId) {
        this.servoId = servoId;
    }

    public String getElecId() {
        return elecId;
    }

    public void setElecId(String elecId) {
        this.elecId = elecId;
    }

    public String getServoModel() {
        return servoModel;
    }

    public void setServoModel(String servoModel) {
        this.servoModel = servoModel;
    }

    public String getElecModel() {
        return elecModel;
    }

    public void setElecModel(String elecModel) {
        this.elecModel = elecModel;
    }

    public String getElecName() {
        return elecName;
    }

    public void setElecName(String elecName) {
        this.elecName = elecName;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Double getCur() {
        return cur;
    }

    public void setCur(Double cur) {
        this.cur = cur;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
