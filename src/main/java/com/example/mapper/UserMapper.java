package com.example.mapper;

import com.example.entity.Account;
import com.example.entity.Admin;
import com.example.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user where  username = #{username}")
    User selectByUsername(String username);

    void insert(User user);

    @Delete("delete from user where id = #{id}")
    void deleteById(Integer id);

    /**
     * 查询所有
     * @param user
     * @return
     */
    List<User> selectAll(User user);

    void updateById(User user);

    @Select("select * from user where id = #{id}")
    User selectById(Integer id);
}
