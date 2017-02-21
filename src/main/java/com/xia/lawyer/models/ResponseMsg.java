package com.xia.lawyer.models;

/**
 * Created by lindeng on 2/17/2017.
 */
public class ResponseMsg<T> {
    int code=200;
    String msg;
    T t;

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

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public ResponseMsg(){}

    public ResponseMsg(int code, String msg, T t) {
        this.code = code;
        this.msg = msg;
        this.t = t;
    }

    public ResponseMsg<T> cleanMsg(ResponseMsg<T> t){
        t.setCode(200);
        t.setMsg("");
        t.setT(null);
        return t;
    }
}
