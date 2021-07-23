package com.start.mapper;

public interface UnifyMapper {
    long count(String tableName);
    void initShiroTable();
    void deleteUserRoot();
    Integer searchRoot();
}
