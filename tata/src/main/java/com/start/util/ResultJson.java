package com.start.util;

import java.util.List;

public class ResultJson {
    long count;
    int code = 0;
    String message;
    List data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ResultJson success(String msg) {
        ResultJson resultJson = new ResultJson();
        resultJson.setMessage(msg);
        return resultJson;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public static ResultJson result(List obj){
        ResultJson resultJson = new ResultJson();
        resultJson.setData(obj);
        return resultJson;
    }
    public static ResultJson result(List obj,long count){
        ResultJson resultJson = new ResultJson();
        resultJson.setData(obj);
        resultJson.setCount(count);
        return resultJson;
    }
}
