package com.test.project.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermissionCache {
    public static final Map<Integer, List<String>> ROLE_SN = new HashMap<>();
    public static boolean verify(Integer id){
        return ROLE_SN.containsKey(id);
    }
}
