package com.server.service.impl;

import com.server.entity.User;
import com.server.mapper.TestMapper;
import com.server.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class TestServiceImpl implements TestService {
    @Autowired
    TestMapper testMapper;
    public void addUser(User user){
        testMapper.addUser(user);
    }

    @Override
    public List<User> getAllData() {
        return testMapper.getAllData();
    }

    @Override
    public void updateUser(User user) {
        if(user.getId()==null) return;
        testMapper.updateUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        testMapper.deleteUser(id);
    }

    @Override
    public void blacklist(Long id) {
        testMapper.blackList(id);
    }

    @Override
    public void whiteList(Long id) {
        testMapper.whiteList(id);
    }


}
