package com.example.warehousemanage.service;

import com.example.warehousemanage.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.warehousemanage.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sun
 * @since 2024-03-31
 */
public interface UserService extends IService<User> {
    public User login(User user);
}
