package com.zhijie.miaosha.mapper;

import com.zhijie.miaosha.cacheutils.base.BaseMapper;
import com.zhijie.miaosha.entity.OrderInfo;
import com.zhijie.miaosha.entity.OrderInfoExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderInfoMapper extends BaseMapper<OrderInfo, OrderInfoExample> {

}