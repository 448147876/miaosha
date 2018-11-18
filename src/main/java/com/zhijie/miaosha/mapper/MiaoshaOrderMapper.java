package com.zhijie.miaosha.mapper;

import com.zhijie.miaosha.cacheutils.base.BaseMapper;
import com.zhijie.miaosha.entity.MiaoshaOrder;
import com.zhijie.miaosha.entity.MiaoshaOrderExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MiaoshaOrderMapper extends BaseMapper<MiaoshaOrder, MiaoshaOrderExample> {

}