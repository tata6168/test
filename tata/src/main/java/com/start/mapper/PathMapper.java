package com.start.mapper;

import com.start.entity.Path;

import java.util.List;

public interface PathMapper {
    void insert(Path path);
    List<Path> select();
}
