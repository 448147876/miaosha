package com.zhijie.miaosha.utils;


import com.zhijie.miaosha.entity.Goods;
import com.zhijie.miaosha.mapper.GoodsMapper;
import com.zhijie.miaosha.utils.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    CacheService cacheService;

    public Goods getGoodsById(Long goodsId) {
            Goods goods = goodsMapper.selectByPrimaryKey(goodsId);

        return goods;
    }
}
