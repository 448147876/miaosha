package com.zhijie.miaosha.mapper;

import com.zhijie.miaosha.cacheutils.base.BaseMapper;
import com.zhijie.miaosha.entity.MiaoshaUser;
import com.zhijie.miaosha.entity.MiaoshaUserExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MiaoshaUserMapper extends BaseMapper<MiaoshaUser, MiaoshaUserExample> {

}