package com.example.demo.bean.datatmp;

public class NameMinMaxAveCur {

    private static final long serialVersionUID = -627597604350146446L;

    private String name;

    private Double min;
    private Double max;
    private Double average;
    private Double cur;


    public NameMinMaxAveCur() {
    }


    public NameMinMaxAveCur(String name, Double min, Double max, Double average, Double cur) {
        this.name = name;
        this.min = min;
        this.max = max;
        this.average = average;
        this.cur = cur;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
