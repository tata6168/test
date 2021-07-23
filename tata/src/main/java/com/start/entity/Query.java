package com.start.entity;

public class Query {
    Long start;
    Integer limit;

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        if(limit==null){
            this.start = start;
        }else {
            this.start = (start-1)*limit;
        }

    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        if(start==null) {
            this.limit = limit;
        }else {
            this.start = (start-1)*limit;
        }
    }

}
