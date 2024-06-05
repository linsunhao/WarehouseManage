package com.example.warehousemanage.mapper;

import com.example.warehousemanage.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sun
 * @since 2024-03-31
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    User login(@Param("user") User user);
}
