package com.test.mapper;


public interface BaseMapper<T> {
    void insert(T t);
    void update(T t);
    void delete(Number id);
    Long count();
}
