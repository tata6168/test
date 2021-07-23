package com.start.mapper;

import com.start.entity.NameIdPer;
import com.start.entity.PerModifiable;
import com.start.entity.Permission;
import com.start.entity.Query;
import org.apache.ibatis.annotations.Param;


import java.util.HashMap;
import java.util.List;

public interface PermissionMapper {
    List<Permission> selectAll(Query query);
    void insert(Permission permission);
    void update(Permission permission);

    int count();

    List<NameIdPer> roleTransferInfo();

    void sst(@Param("permissionId") Integer permissionId,@Param("status") Boolean status);

    void update(PerModifiable map);
}
