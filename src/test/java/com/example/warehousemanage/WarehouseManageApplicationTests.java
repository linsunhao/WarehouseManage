package com.example.warehousemanage;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.warehousemanage.entity.Goods;
import com.example.warehousemanage.entity.Record;
import com.example.warehousemanage.entity.User;
import com.example.warehousemanage.mapper.GoodsMapper;
import com.example.warehousemanage.mapper.RecordMapper;
import com.example.warehousemanage.mapper.UserMapper;
import com.example.warehousemanage.service.GoodsService;
import com.example.warehousemanage.service.RecordService;
import com.example.warehousemanage.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WarehouseManageApplicationTests {
    @Autowired
    GoodsService goodsService;

    @Test
    void contextLoads() {
//        Page<Record> page =new Page<Record>();
//        page.setSize(5);
//        page.setCurrent(1);
//        QueryWrapper<Record> wrapper =new QueryWrapper<>();
//        wrapper.eq("record.id",1);
//        List<Record> l= mapper.Page(page, wrapper);
        Record record = new Record();
        record.setGoods(5);
        Goods byId = goodsService.getById(record.getGoods());
        System.out.println(byId);
    }

}
