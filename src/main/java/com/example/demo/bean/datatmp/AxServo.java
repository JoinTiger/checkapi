package com.example.demo.bean.datatmp;

public class AxServo {
    private static final long serialVersionUID = -7922877748141567466L;

    private String axisName;

    private String servoId;

    private String elecId;

    private String servoModel;

    private String elecModel;

    public AxServo() {
    }


    public AxServo(String axisName, String servoId, String elecId, String servoModel, String elecModel) {
        this.axisName = axisName;
        this.servoId = servoId;
        this.elecId = elecId;
        this.servoModel = servoModel;
        this.elecModel = elecModel;
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
}
