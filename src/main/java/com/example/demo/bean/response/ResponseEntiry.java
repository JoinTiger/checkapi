package com.example.demo.bean.response;

import java.io.Serializable;

public class ResponseEntiry implements Serializable {

    private static final long serialVersionUID = 4662380240282012047L;

    private String msgDesc;

    private Integer msgCode;

    private Object data;

    public ResponseEntiry() {
    }

    public ResponseEntiry(String msgDesc, Integer msgCode, Object data) {
        this.msgDesc = msgDesc;
        this.msgCode = msgCode;
        this.data = data;
    }

    public String getMsgDesc() {
        return msgDesc;
    }

    public void setMsgDesc(String msgDesc) {
        this.msgDesc = msgDesc;
    }

    public Integer getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(Integer msgCode) {
        this.msgCode = msgCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
