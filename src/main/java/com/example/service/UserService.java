package com.example.service;

import com.example.entity.Admin;
import com.example.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {
    void add(User user);

    void deleteById(Integer id);

    PageInfo<User> selectPage(User user, Integer pageNum, Integer pageSize);

    void deleteBatch(List<Integer> ids);

    void updateById(User user);
}