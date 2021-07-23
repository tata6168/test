package com.test.project.util;

public class Query {
    String keywords;
    //PageSize
    Integer limit;
    //startIndex
    Integer page;

    public void setLimit(Integer limit) {
        if(page==null){
            this.limit = limit;
        }else {
            this.page = (this.page-1)*limit;
        }
    }

    public void setPage(Integer page) {
        if(limit==null) {
            this.page = page;
        }else {
            this.page = (page-1)*this.limit;
        }
    }


//    public void setLimit(Integer limit) {
//        if(this.page==null) {
//            this.limit = limit;
//        }else {
//            int buf = limit;
//            this.limit = (page-1)*limit;
//            this.page = (page)*buf-1;
//        }
//    }
//    public void setPage(Integer page) {
//        if (null==this.limit) {
//            this.page = page;
//        }else {
//            int buf = limit;
//            this.limit = (page-1)*limit;
//            this.page = (page)*buf-1;
//        }
//    }

    public Integer getLimit() {
        return limit;
    }

    public Integer getPage() {
        return page;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}
