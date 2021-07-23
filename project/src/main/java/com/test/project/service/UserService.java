package com.test.project.service;

import com.test.project.entity.TransferUpdateInfo;
import com.test.project.entity.User;
import com.test.project.util.Query;

import java.util.List;

public interface UserService {
    List<User> searchPage(Query query);
    Long count();
    List<String> userGetPermission(Long userId);
    void register(User user);
    List<Integer> searchRoleIds(Long userId);

    void updateRole(TransferUpdateInfo info);


}
