package com.start.entity;

import java.util.ArrayList;
import java.util.List;

/*
* 中间表
* */
public class IntermediateDate {
    Integer mainId;
    List<Number> delete = new ArrayList<>();
    List<Number> insert = new ArrayList<>();
    /*
    * 1  insert
    * 0  insert/delete
    * -1 delete
    * */
    int sign;

    public int getSign() {
        return sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }

    public Integer getMainId() {
        return mainId;
    }

    public void setMainId(Integer mainId) {
        this.mainId = mainId;
    }

    public List<Number> getDelete() {
        return delete;
    }

    public void setDelete(List<Number> delete) {
        this.delete = delete;
    }

    public List<Number> getInsert() {
        return insert;
    }

    public void setInsert(List<Number> insert) {
        this.insert = insert;
    }
}
