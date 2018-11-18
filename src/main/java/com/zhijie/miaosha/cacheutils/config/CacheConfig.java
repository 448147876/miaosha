package com.zhijie.miaosha.cacheutils.config;


/**
 * @Description: 缓存的配置
 * @auther: 童志杰
 * @date: 2018/11/14
 */
public class CacheConfig {
    /**
     * 项目名称，用于区分各个系统的缓存
     */
    public static final String PROJECT_NAME = "yhzhaj";
    /**
     * @Description: 使用的缓存类型
     * @auther: 童志杰
     * @date: 2018/11/14
     */
    public static final String USE_CACHE = "redis";
    /**
     * @Description: redis
     * @auther: 童志杰
     * @date: 2018/11/14
     */
    public static final String REDIS = "redis";
    /**
     * @Description: ecache
     * @auther: 童志杰
     * @date: 2018/11/14
     */
    public static final String ECACHE = "ecache";

    /**
     * @Description: 方法级别的缓存
     * @auther: 童志杰
     * @date: 2018/11/14
     */
    public static final String METHOD = "method";

}
