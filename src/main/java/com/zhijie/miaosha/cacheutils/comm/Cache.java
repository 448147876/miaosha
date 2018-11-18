package com.zhijie.miaosha.cacheutils.comm;


import java.util.List;

/**
 * @Description:缓存类基础方法接口
 * @author: 童志杰
 * @Date:2018/10/9
 */
public interface Cache {

    /**
     * 获取一个缓存
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 根据前缀获取缓存
     * @param prefix
     * @return
     */
    List<String> getPrefix(String prefix);

    /**
     * 存入缓存（没有有效期）
     * @param key
     * @param value
     * @return
     */
    boolean set(String key, String value);

    /**
     * 存入缓存（有效期时间）
     * @param key
     * @param value
     * @param time
     * @return
     */
    boolean setTime(String key, String value, int time);

    /**
     * 缓存是否存在
     * @param key
     * @return
     */
    boolean exit(String key);

    /**
     * 删除一个缓存，返回当前缓存
     * @param key
     * @return
     */
    Boolean remove(String key);

    /**
     * 根据前缀删除
     * @param prefix
     * @return
     */
    boolean removePrefix(String prefix);

    /**
     * 递减
     * @param key
     * @return
     */
    Long decr(String key);

    /**
     * 递加
     * @param key
     * @return
     */
    Long incr(String key);


}
