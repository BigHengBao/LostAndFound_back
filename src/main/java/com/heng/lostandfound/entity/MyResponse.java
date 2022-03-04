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
    private boolean result;

    public MyResponse(String requestId, boolean result) {
        this.requestId = requestId;
        this.result = result;
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
                ", result=" + result +
                '}';
    }
}
