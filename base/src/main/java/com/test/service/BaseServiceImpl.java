package com.test.service;

import com.test.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class BaseServiceImpl<T> implements BaseService<T> {
    @Autowired
    BaseMapper<T> baseMapper;

    @Override
    public void insert(T t) {
        baseMapper.insert(t);
    }

    @Override
    public void update(T t) {
        baseMapper.update(t);
    }

    @Override
    public void delete(Number id) {
        baseMapper.delete(id);
    }

    @Override
    public Long count() {
        return baseMapper.count();
    }
}
