package com.xia.lawyer.util;

/**
 * Created by lindeng on 2/17/2017.
 */
public enum  ResponseStatus {
    C200(200,"successfully"),
    C404(404,"not found"),
    C403(403,"have no right ");
    private int code;
    private String msg;

    private ResponseStatus(){}

    private ResponseStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
