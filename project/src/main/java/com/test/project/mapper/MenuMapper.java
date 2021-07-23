package com.test.project.mapper;

import com.test.project.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {
    List<Menu> userGetMenu(Long userId);
    List<Menu> roleBatchMenu(@Param("roleIds") List<Integer> roleIds);
    void add(Menu menu);
    void delete(Integer id);
    void update(Menu menu);
}
