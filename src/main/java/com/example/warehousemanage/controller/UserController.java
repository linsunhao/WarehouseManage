package com.example.warehousemanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.warehousemanage.Utils.Code;
import com.example.warehousemanage.Utils.JwtUtils;
import com.example.warehousemanage.Utils.Result;
import com.example.warehousemanage.entity.QueryPageAndParams;
import com.example.warehousemanage.entity.User;
import com.example.warehousemanage.service.UserService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sun
 * @since 2024-03-31
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    //查询所有用户
    @GetMapping("/list")
    public Result ListAllUser(){
        List<User> list = userService.list();
        if(list.size() != 0){
            return Result.suc(Code.SELECT_OK,"查询所有用户成功",list,Long.valueOf(list.size()));
        }else{
            return Result.fail(Code.SELECT_ERR,"查询所有用户失败",null,0L);
        }
    }
    //通过账号查找用户
    @GetMapping("/listByNo")
    public Result listByNo(@RequestParam String no){
        List<User> list = userService.lambdaQuery().eq(User::getNo, no).list();
        if(list.size() != 0){
            return Result.suc(Code.SELECT_OK,"账号查询用户成功",list,Long.valueOf(list.size()));
        }else{
            return Result.fail(Code.SELECT_ERR,"账号查询用户失败",null,0L);
        }
    }

    //增加用户
    @PostMapping("/save")
    public Result save(@RequestBody User user){
        boolean save = userService.save(user);
        if(save){
            return Result.suc(Code.ADD_OK,"添加用户成功",save,1L);
        }else{
            return Result.fail(Code.ADD_ERR,"添加用户失败",save,0L);
        }
    }

    //修改用户
    @PutMapping("/update")
    public Result update(@RequestBody User user){
        boolean update = userService.updateById(user);
        if(update){
            return Result.suc(Code.UPDATE_OK,"修改用户成功",update,1L);
        }else{
            return Result.suc(Code.UPDATE_OK,"修改用户成功",update,0L);
        }
    }

    //增加或修改用户
    @PostMapping("saveorupdate")
    public Result saveOrUpdate(@RequestBody User user){
        //saveOrUpdate通过user的id去表中查询，如果有该用户则更新，没有则新增(包括无id)
        boolean b = userService.saveOrUpdate(user);
        if(b){
            return Result.suc(Code.DEFAULT_OK,"添加或修改用户成功",b,1L);
        }else{
            return Result.suc(Code.DEFAULT_ERR,"添加或修改用户成失败",b,0L);
        }
    }

    //删除用户
    @DeleteMapping("/delete")
    public Result delete(Integer id){
        boolean b = userService.removeById(id);
        if(b){
            return Result.suc(Code.DELETE_OK,"删除用户成功",b,1L);
        }else{
            return Result.suc(Code.DELETE_ERR,"删除用户成失败",b,0L);
        }
    }

    //模糊查询
    @GetMapping("/listP")
    public Result listP(@RequestBody User user){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.likeLeft(user.getUsername() != null, "username", "%"+user.getUsername()+"%");
        List<User> list = userService.list(wrapper);
        if(list.size() != 0){
            return Result.suc(Code.SELECT_OK,"模糊查询用户成功",list,Long.valueOf(list.size()));
        }else{
            return Result.fail(Code.SELECT_ERR,"模糊查询用户失败",null,0L);
        }
    }

    /**
     * 1、在MyBatis-Plus中最常用的分页查询的方法是结合 IPage 接口和 Page 类来实现，也是 MyBatis-Plus 官方推荐的方式。
     * 2、同时还支持使用 PageHelper 插件进行分页查询，但这通常用于 MyBatis 原生集成，而不是 MyBatis-Plus。
     */
    //分页查询(使用MyBatis-Plus的page实现)
    @PostMapping("/listPage")
    public Result listPage(@RequestBody QueryPageAndParams pageAndParams){
        //获取分页条件与查询条件
        Integer pageSize = pageAndParams.getPageSize();
        Integer pageNum = pageAndParams.getPageNum();
        HashMap params = pageAndParams.getParams();
        //获取键值对集合
        Set<Map.Entry> set = params.entrySet();


        //设置分页条件
        Page<User> page = new Page();
        page.setCurrent(pageNum); //设置当前页
        page.setSize(pageSize);  //设置页面大小

        //设置查询的信息条件
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //例遍键值对
        for (Map.Entry entry : set) {
            wrapper.like(entry.getKey().toString(),entry.getValue());
        }
        //将分页条件与信息条件传参给page分页查询方法（page为MyBatis-Plus自带的分页查询接口）
        Page<User> userPage = userService.page(page, wrapper);

        //解析查询结果
        List<User> userList = userPage.getRecords();//getRecords获取分页查询的结果列表
        long pages = userPage.getPages();//获取查询到的页数
        long total = userPage.getTotal();//获取查询结果的总数
        if(total != 0){
            return Result.suc(Code.SELECT_OK,"分页查询用户成功",userPage,total);
        }else{
            return Result.fail(Code.SELECT_ERR,"分页查询用户失败",null,0L);
        }
    }

    //用户登陆
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        User login = userService.login(user);
        if(login != null){
            return Result.suc(Code.LOGIN_OK,"用户登录成功",login,1L).token(JwtUtils.generateToken(login.getNo()));
        }else{
            return Result.fail(Code.LOGIN_ERR,"用户登录失败",null,0L);
        }
    }

    //通过token获取用户信息
    @GetMapping("/info")
    public Result info(HttpServletRequest request){
        String token = request.getHeader("Authorization"); //获取请求头中的Authorization字段，其存有token字段
        if("".equals(token) || token == null){
            return Result.fail(Code.SELECT_OK,"用户信息查询失败",null,0L);
        }
        token = token.substring(7);  //去除token字段前的‘Bearer ’标识
        String no = JwtUtils.getClaimsByToken(token.trim()).getSubject();
        List<User> list = userService.lambdaQuery().eq(User::getNo, no).list();
        if(list.size() > 0){
            User user = list.get(0);
            user.setPassword("");
            return Result.suc(Code.SELECT_OK,"用户信息查询成功",user,Long.valueOf(list.size()));
        }else{
            return Result.fail(Code.SELECT_OK,"用户信息查询失败",null,Long.valueOf(list.size()));
        }
    }

}
