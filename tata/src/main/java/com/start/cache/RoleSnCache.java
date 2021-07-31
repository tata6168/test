package com.start.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RoleSnCache {
    /*
    * 角色Id / sn
    * */
    public static final Map<Integer, Set<String>> ROLE_ID_SN = new HashMap<>();
    /*
    * registerInitRoleId 用户注册拥有的角色Id
    * */
    public static Integer registerInitRoleId;
    /*
    * 所有表的Count tableName / count
    * */
    public static Map<String,Integer> TABLE_COUNT = new HashMap<>();
}
