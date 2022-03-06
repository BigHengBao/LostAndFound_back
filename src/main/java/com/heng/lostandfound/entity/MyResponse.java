package com.heng.lostandfound.entity;

import java.io.Serializable;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/4/20:33
 * title：
 */
public class MyResponse implements Serializable {
    private String requestId;
    private String frontend;
    private boolean result;
    private String msg;

    public MyResponse(String requestId, String frontend, boolean result, String msg) {
        this.requestId = requestId;
        this.frontend = frontend;
        this.result = result;
        this.msg = msg;
    }

    public String getFrontend() {
        return frontend;
    }

    public void setFrontend(String frontend) {
        this.frontend = frontend;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "MyResponse{" +
                "requestId='" + requestId + '\'' +
                ", frontend='" + frontend + '\'' +
                ", result=" + result +
                ", msg='" + msg + '\'' +
                '}';
    }
}
