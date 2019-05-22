package com.example.demo.bean.datatmp;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ElecData implements Serializable {

    private static final long serialVersionUID = -855791970390552622L;

    private AxServo axServo;

    @JsonProperty("eleDataArr")
    private List<NameMinMaxAveCur> nameMinMaxAveCurs = new ArrayList<>();


    public ElecData() {
    }

    public ElecData(AxServo axServo, List<NameMinMaxAveCur> nameMinMaxAveCurs) {
        this.axServo = axServo;
        this.nameMinMaxAveCurs = nameMinMaxAveCurs;
    }

    public AxServo getAxServo() {
        return axServo;
    }

    public void setAxServo(AxServo axServo) {
        this.axServo = axServo;
    }

    public List<NameMinMaxAveCur> getNameMinMaxAveCurs() {
        return nameMinMaxAveCurs;
    }

    public void setNameMinMaxAveCurs(List<NameMinMaxAveCur> nameMinMaxAveCurs) {
        this.nameMinMaxAveCurs = nameMinMaxAveCurs;
    }
}
