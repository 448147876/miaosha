package com.zhijie.miaosha.mapper;

import com.zhijie.miaosha.cacheutils.base.BaseMapper;
import com.zhijie.miaosha.entity.MiaoshaGoods;
import com.zhijie.miaosha.entity.MiaoshaGoodsExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MiaoshaGoodsMapper extends BaseMapper<MiaoshaGoods, MiaoshaGoodsExample> {

}