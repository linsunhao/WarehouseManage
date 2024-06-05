package com.example.warehousemanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.warehousemanage.Utils.Code;
import com.example.warehousemanage.Utils.Result;
import com.example.warehousemanage.entity.Goods;
import com.example.warehousemanage.entity.Record;
import com.example.warehousemanage.entity.QueryPageAndParams;
import com.example.warehousemanage.entity.User;
import com.example.warehousemanage.service.GoodsService;
import com.example.warehousemanage.service.RecordService;
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
@RequestMapping("/record")
@CrossOrigin
public class RecordController {
    @Autowired
    private RecordService recordService;
    @Autowired
    private GoodsService goodsService;
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
        Page<Record> page = new Page();
        page.setCurrent(pageNum); //设置当前页
        page.setSize(pageSize);  //设置页面大小

        //设置查询的信息条件
        QueryWrapper<Record> wrapper = new QueryWrapper<>();
        wrapper.apply("record.goods = goods.id and goods.goodsType = goodstype.id and goods.`storage` = `storage`.id ");
//        例遍键值对
        for (Map.Entry entry : set) {
            if(entry.getKey().toString().equals("name")){
                wrapper.like("goods."+entry.getKey().toString(),entry.getValue());
            } else if (entry.getKey().toString().equals("goodstypeName")) {
                wrapper.like("goodstype.name",entry.getValue());
            }else{
                wrapper.like("storage.name",entry.getValue());
            }
        }
        //将分页条件与信息条件传参给page分页查询方法（page为MyBatis-Plus自带的分页查询接口）
        IPage<Record> goodsPage = recordService.listPage(page, wrapper);

        //解析查询结果
        List<Record> goodsList = goodsPage.getRecords();//getRecords获取分页查询的结果列表
        long pages = goodsPage.getPages();//获取查询到的页数
        long total = goodsPage.getTotal();//获取查询结果的总数
        if(total != 0){
            return Result.suc(Code.SELECT_OK,"分页记录查询成功",goodsPage,total);
        }else{
            return Result.fail(Code.SELECT_ERR,"分页记录查询失败",null,0L);
        }
    }

    @PostMapping("/save")
    public Result save(@RequestBody Record record){
        Goods goods = goodsService.getById(record.getGoods());
        Integer oldCount = goods.getCount();
        if(0 == record.getAction()){
            goods.setCount(oldCount-record.getCount());
            record.setCount(-record.getCount());
        }else{
            goods.setCount(oldCount+record.getCount());
        }
        boolean save = recordService.save(record);
        boolean b = goodsService.saveOrUpdate(goods);
        if(save && b){
            return Result.suc(Code.ADD_OK,"添加记录成功",save,1L);
        }else{
            return Result.fail(Code.ADD_ERR,"添加记录失败",save,0L);
        }
    }
}
