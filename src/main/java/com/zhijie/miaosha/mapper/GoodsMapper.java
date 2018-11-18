package com.zhijie.miaosha.mapper;

import com.zhijie.miaosha.cacheutils.comm.BaseDao;
import com.zhijie.miaosha.entity.Goods;
import com.zhijie.miaosha.entity.GoodsExample;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface GoodsMapper extends BaseDao<Goods, GoodsExample> {

}