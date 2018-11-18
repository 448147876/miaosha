package com.zhijie.miaosha.cacheutils.service;

import com.zhijie.miaosha.cacheutils.comm.BaseServiceImpl;
import com.zhijie.miaosha.entity.Goods;
import com.zhijie.miaosha.entity.GoodsExample;
import com.zhijie.miaosha.mapper.GoodsMapper;
import org.springframework.stereotype.Service;


@Service
public class HelloServiceImpl extends BaseServiceImpl<GoodsMapper, Goods, GoodsExample> implements HelloService {

}
