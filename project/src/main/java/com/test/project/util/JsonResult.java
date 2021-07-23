package com.test.project.util;

import java.util.List;

public class JsonResult {
    int code = 0;
    String msg;
    Long count;
    List data;
    public static JsonResult packaging(List data,Long count,String msg){
        JsonResult jsonResult = new JsonResult();
        jsonResult.msg=msg;
        jsonResult.data=data;
        jsonResult.count=count;
        return jsonResult;
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

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
