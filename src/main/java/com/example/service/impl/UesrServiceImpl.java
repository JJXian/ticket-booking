package com.example.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.Constants;
import com.example.common.enums.ResultCodeEnum;
import com.example.common.enums.RoleEnum;
import com.example.entity.Account;
import com.example.entity.User;
import com.example.exception.CustomException;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import com.example.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: jjxian
 * @CreateTime: 2024-05-31
 */

/**
 * 用户业务相关
 */
@Service
public class UesrServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public void add(User user) {
//        查询用户表有没有该用户
        User dbuser = userMapper.selectByUsername(user.getUsername());
        if(!ObjectUtil.isEmpty(dbuser)){
            throw new CustomException(ResultCodeEnum.USER_EXIST_ERROR);
        }
        if(ObjectUtil.isEmpty(user.getPassword())){
            user.setPassword(Constants.USER_DEFAULT_PASSWORD);
        }
        if(ObjectUtil.isEmpty(user.getName())){
            user.setName(user.getUsername());
        }
        user.setRole(RoleEnum.USER.name());
        userMapper.insert(user);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }

    /**
     * 分页查询
     * @param user
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<User> selectPage(User user, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userMapper.selectAll(user);
        return PageInfo.of(list);
    }


    @Override
    public void deleteBatch(List<Integer> ids) {
        for(Integer id : ids){
            userMapper.deleteById(id);
        }
    }

    @Override
    public void updateById(User user) {
        User dbuser = userMapper.selectByUsername(user.getUsername());
        if(ObjectUtil.isEmpty(dbuser)){
           throw new CustomException(ResultCodeEnum.USER_NOT_EXIST_ERROR);
        }
        userMapper.updateById(user);
    }

    @Override
    public Account login(Account account) {
        Account dbUser = userMapper.selectByUsername(account.getUsername());
        if (ObjectUtil.isNull(dbUser)) {
            throw new CustomException(ResultCodeEnum.USER_NOT_EXIST_ERROR);
        }
        if (!account.getPassword().equals(dbUser.getPassword())) {
            throw new CustomException(ResultCodeEnum.USER_ACCOUNT_ERROR);
        }
        // 生成token
        String tokenData = dbUser.getId() + "-" + RoleEnum.USER.name();
        String token = TokenUtils.createToken(tokenData, dbUser.getPassword());
        dbUser.setToken(token);
        return dbUser;
    }

    @Override
    public void register(Account account) {
        User user = new User();
        BeanUtils.copyProperties(account, user);
        add(user);
    }

    @Override
    public Account selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public void updatePassword(Account account) {
        User dbUser = userMapper.selectByUsername(account.getUsername());
        if (ObjectUtil.isNull(dbUser)) {
            throw new CustomException(ResultCodeEnum.USER_NOT_EXIST_ERROR);
        }
        if (!account.getPassword().equals(dbUser.getPassword())) {
            throw new CustomException(ResultCodeEnum.PARAM_PASSWORD_ERROR);
        }
        dbUser.setPassword(account.getNewPassword());
        userMapper.updateById(dbUser);
    }


}
