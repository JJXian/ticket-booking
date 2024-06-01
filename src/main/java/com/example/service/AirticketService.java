package com.example.service;

import com.example.entity.Airticket;
import com.example.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AirticketService {
    void add(Airticket airticket);

    void deleteById(Integer id);

    PageInfo<Airticket> selectPage(Airticket airticket, Integer pageNum, Integer pageSize);

    void deleteBatch(List<Integer> ids);

    void updateById(Airticket airticket);

    Airticket selectById(Integer id);
}
