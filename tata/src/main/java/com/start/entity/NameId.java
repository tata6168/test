package com.start.entity;

public class NameId {
    Integer id;
    String name;

    public Number getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NameId{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

