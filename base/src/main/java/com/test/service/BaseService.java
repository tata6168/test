package com.test.service;

import com.test.demo.Entity;

public interface BaseService<T> {
    void insert(T t);
    void update(T t);
    void delete(Number id);
    Long count();
}
