package com.start.entity;

import java.util.ArrayList;
import java.util.List;

public class TransferEntity {
    Integer id;
    List<? extends NameId> nameIdList = new ArrayList<>();
    List<Integer> ids = new ArrayList<>();
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public List<? extends NameId> getNameIdList() {
        return nameIdList;
    }

    public void setNameIdList(List<? extends  NameId > nameIdList) {
        this.nameIdList = nameIdList;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
