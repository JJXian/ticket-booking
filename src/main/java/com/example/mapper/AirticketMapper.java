package com.example.mapper;

import com.example.entity.Airticket;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AirticketMapper {

    void insert(Airticket airticket);

    @Delete("delete  from airticket where id = #{id}")
    void deleteById(Integer id);

    List<Airticket> selectAll(Airticket airticket);

    void updateById(Airticket airticket);

    @Select("select * from airticket where id = #{id}")
    Airticket selectById(Integer id);
}
