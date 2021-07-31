package com.start.service.impl;

import com.start.mapper.UnifyMapper;
import com.start.service.UnifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UnifyServiceImpl implements UnifyService {
    @Autowired
    UnifyMapper unifyMapper;

    @Override
    @Cacheable(cacheNames = "count")
    public long count(String tableName) {
        return unifyMapper.count(tableName);
    }
}
