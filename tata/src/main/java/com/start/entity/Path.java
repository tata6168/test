package com.start.entity;

public class Path {
    Integer pathId;
    String path;
    Boolean status;
    /*
     * status 1：页面跳转 0：待确定 -1：功能路径 -2:父级菜单
     * */
    Integer sign;

    public Path( String path, Boolean status, Integer sign) {
        this.path = path;
        this.status = status;
        this.sign = sign;
    }

    public Path() {
    }

    public Integer getPathId() {
        return pathId;
    }

    public void setPathId(Integer pathId) {
        this.pathId = pathId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
    }
}
