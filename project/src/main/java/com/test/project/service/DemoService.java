package com.test.project.service;

import com.test.project.entity.Demo;

import java.util.List;

public interface DemoService {
    void insert(Demo demo);
    void update(Demo demo);
    List<Demo> searchList();
    void delete(Long id);
}
