package com.example.service.impl;

import com.example.entity.Airticket;
import com.example.mapper.AirticketMapper;
import com.example.service.AirticketService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: jjxian
 * @CreateTime: 2024-06-01
 */
@Service
public class AriticketServiceImpl implements AirticketService {

    @Autowired
    private AirticketMapper airticketMapper;

    @Override
    public void add(Airticket airticket) {
        airticketMapper.insert(airticket);
    }

    @Override
    public void deleteById(Integer id) {
        airticketMapper.deleteById(id);
    }


    /**
     * 分页查询
     * @param airticket
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Airticket> selectPage(Airticket airticket, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Airticket> list = airticketMapper.selectAll(airticket);
        return PageInfo.of(list);
    }

    @Override
    public void deleteBatch(List<Integer> ids) {
        for(Integer id : ids){
            airticketMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Airticket airticket) {
        airticketMapper.updateById(airticket);
    }

    /**
     * 根据ID查询
     */
    public Airticket selectById(Integer id) {
        return airticketMapper.selectById(id);
    }
}
