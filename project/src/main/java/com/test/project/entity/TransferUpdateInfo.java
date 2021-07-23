package com.test.project.entity;

import java.util.ArrayList;
import java.util.List;

public class TransferUpdateInfo {
    Number primaryId;
    List<Number> insert = new ArrayList<>();
    List<Number> delete = new ArrayList<>();

    public Number getPrimaryId() {
        return primaryId;
    }

    public void setPrimaryId(Number primaryId) {
        this.primaryId = primaryId;
    }

    public List<Number> getInsert() {
        return insert;
    }

    public void setInsert(List<Number> insert) {
        this.insert = insert;
    }

    public List<Number> getDelete() {
        return delete;
    }

    public void setDelete(List<Number> delete) {
        this.delete = delete;
    }
}
