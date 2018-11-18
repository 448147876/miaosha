package com.zhijie.miaosha.cacheutils.comm;


import com.zhijie.miaosha.cacheutils.config.CacheConfig;

/**
 * @Description: 缓存的前缀
 * @auther: 童志杰
 * @date: 2018/11/14
 */
public abstract class BasePrefix implements KeyPrefix {

    private int expireSeconds;

    private String prefix;

    /**
     * 0代表永不过期
     * @param prefix
     */
    public BasePrefix(String prefix) {
        this(0, prefix);
    }

    public BasePrefix(int expireSeconds, String prefix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    @Override
    public int expireSeconds() {//默认0代表永不过期
        return expireSeconds;
    }

    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();
        return CacheConfig.PROJECT_NAME+":"+className + ":" + prefix;
    }

}
