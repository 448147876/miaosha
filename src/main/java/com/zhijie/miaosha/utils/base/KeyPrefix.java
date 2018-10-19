package com.zhijie.miaosha.utils.base;


/**
 * @Description:前缀接口
 * @author: 童志杰
 * @Date:2018/10/18
 */
public interface KeyPrefix {

    public int expireSeconds();

    public String getPrefix();

}
