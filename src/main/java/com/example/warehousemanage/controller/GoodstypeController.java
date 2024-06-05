package com.example.warehousemanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.warehousemanage.Utils.Code;
import com.example.warehousemanage.Utils.Result;
import com.example.warehousemanage.entity.QueryPageAndParams;
import com.example.warehousemanage.entity.Goodstype;
import com.example.warehousemanage.entity.User;
import com.example.warehousemanage.service.GoodstypeService;
import com.example.warehousemanage.service.GoodstypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sun
 * @since 2024-04-09
 */
@RestController
@RequestMapping("/goodstype")
@CrossOrigin
public class GoodstypeController {
    @Autowired
    private GoodstypeService goodstypeService;

    @GetMapping("/list")
    public Result ListAll(){
        List<Goodstype> list = goodstypeService.list();
        if(list.size() != 0){
            return Result.suc(Code.SELECT_OK,"查询所有货物类型成功",list,Long.valueOf(list.size()));
        }else{
            return Result.fail(Code.SELECT_ERR,"查询所有货物类型失败",null,0L);
        }
    }
    @PutMapping("/update")
    public Result update(@RequestBody Goodstype goodstype){
        boolean update = goodstypeService.updateById(goodstype);
        if(update){
            return Result.suc(Code.UPDATE_OK,"修改货物类型成功",update,1L);
        }else{
            return Result.suc(Code.UPDATE_OK,"修改货物类型成功",update,0L);
        }
    }

    //增加或修改
    @PostMapping("saveorupdate")
    public Result saveOrUpdate(@RequestBody Goodstype goodstype){
        System.out.println(goodstype);
        //saveOrUpdate通过goodstype的id去表中查询，如果有该用户则更新，没有则新增(包括无id)
        boolean b = goodstypeService.saveOrUpdate(goodstype);
        if(b){
            return Result.suc(Code.DEFAULT_OK,"添加或修改货物类型成功",b,1L);
        }else{
            return Result.suc(Code.DEFAULT_ERR,"添加或修改货物类型失败",b,0L);
        }
    }

    //删除
    @DeleteMapping("/delete")
    public Result delete(Integer id){
        boolean b = goodstypeService.removeById(id);
        if(b){
            return Result.suc(Code.DELETE_OK,"删除货物类型成功",b,1L);
        }else{
            return Result.suc(Code.DELETE_ERR,"删除仓货物类型失败",b,0L);
        }
    }

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
        Page<Goodstype> page = new Page();
        page.setCurrent(pageNum); //设置当前页
        page.setSize(pageSize);  //设置页面大小

        //设置查询的信息条件
        QueryWrapper<Goodstype> wrapper = new QueryWrapper<>();
        //例遍键值对
        for (Map.Entry entry : set) {
            wrapper.like(entry.getKey().toString(),entry.getValue());
        }
        //将分页条件与信息条件传参给page分页查询方法（page为MyBatis-Plus自带的分页查询接口）
        Page<Goodstype> goodstypePage = goodstypeService.page(page, wrapper);

        //解析查询结果
        List<Goodstype> goodstypeList = goodstypePage.getRecords();//getRecords获取分页查询的结果列表
        long pages = goodstypePage.getPages();//获取查询到的页数
        long total = goodstypePage.getTotal();//获取查询结果的总数
        if(total != 0){
            return Result.suc(Code.SELECT_OK,"分页查询货物类型成功",goodstypePage,total);
        }else{
            return Result.fail(Code.SELECT_ERR,"分页查询货物类型失败",null,0L);
        }
    }

    @GetMapping("/listByName")
    public Result listByNo(@RequestParam String name){
        List<Goodstype> list = goodstypeService.lambdaQuery().eq(Goodstype::getName, name).list();
        if(list.size() != 0){
            return Result.suc(Code.SELECT_OK,"账号查询货物类型成功",list,Long.valueOf(list.size()));
        }else{
            return Result.fail(Code.SELECT_ERR,"账号查询货物类型失败",null,0L);
        }
    }
}
