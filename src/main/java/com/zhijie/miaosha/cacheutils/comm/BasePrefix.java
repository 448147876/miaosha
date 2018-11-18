package com.zhijie.miaosha.cacheutils.comm;

import com.zhijie.miaosha.cacheutils.comm.KeyPrefix;
import com.zhijie.miaosha.cacheutils.config.CacheConfig;

public abstract class BasePrefix implements KeyPrefix {

    private int expireSeconds;

    private String prefix;

    //0代表永不过期
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
        return CacheConfig.PROJECT_NAME+":"+className + ":" + prefix+":";
    }

}
