package com.test.project.service.impl;

import com.test.project.entity.Demo;
import com.test.project.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;
    @Override
    public void insert(Demo demo) {
        elasticsearchTemplate.createIndex(Demo.class);
        elasticsearchTemplate.putMapping(Demo.class);
    }

    @Override
    public void update(Demo demo) {
        Map<String, Object> mapping = elasticsearchTemplate.getMapping(Demo.class);
        System.out.println(mapping);
    }

    @Override
    public List<Demo> searchList() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
