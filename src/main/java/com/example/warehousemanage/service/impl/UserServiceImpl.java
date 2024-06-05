package com.example.warehousemanage.service.impl;

import com.example.warehousemanage.entity.User;
import com.example.warehousemanage.mapper.UserMapper;
import com.example.warehousemanage.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sun
 * @since 2024-03-31
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(User user) {
        User login = userMapper.login(user);
        return login;
    }
}
