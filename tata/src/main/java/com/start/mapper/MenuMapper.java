package com.start.mapper;

import com.start.entity.IntermediateDate;
import com.start.entity.Menu;

import java.util.List;

public interface MenuMapper {
    void insert(Menu menu);
    void update(Menu menu);
    void roleAddMenu(IntermediateDate intermediateDate);
    void roleDeleteMenu(IntermediateDate intermediateDate);
    List<Menu> searchMenuJava(Long userId);
    List<Menu> searchMenuSql(Long userId);

    List<Menu> getAllMenu();

    void delBatchMenu(int[] menuIds);
}
