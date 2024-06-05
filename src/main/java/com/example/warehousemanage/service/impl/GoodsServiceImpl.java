package com.example.warehousemanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.warehousemanage.entity.Goods;
import com.example.warehousemanage.mapper.GoodsMapper;
import com.example.warehousemanage.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sun
 * @since 2024-04-09
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public IPage<Goods> listPage(IPage<Goods> page, Wrapper<Goods> wrapper) {
        return page.setRecords(goodsMapper.Page(page,wrapper));
    }
}
