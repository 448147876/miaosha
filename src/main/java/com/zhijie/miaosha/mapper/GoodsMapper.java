package com.zhijie.miaosha.mapper;

import com.zhijie.miaosha.cacheutils.base.BaseMapper;
import com.zhijie.miaosha.entity.Goods;
import com.zhijie.miaosha.entity.GoodsExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsMapper extends BaseMapper<Goods, GoodsExample> {

}