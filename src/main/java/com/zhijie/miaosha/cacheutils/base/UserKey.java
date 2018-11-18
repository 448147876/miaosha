package com.zhijie.miaosha.cacheutils.base;


import com.zhijie.miaosha.cacheutils.comm.BasePrefix;

/**
 * @Description: 传感器信息
 * @auther: 童志杰
 * @date: 2018/11/14
 */
public class UserKey extends BasePrefix {

    private UserKey(String prefix) {
        super(prefix);
    }

    private UserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    /**
     * 根据传感器id
     */
    public static UserKey selectByPK = new UserKey(0, "PK");

}
