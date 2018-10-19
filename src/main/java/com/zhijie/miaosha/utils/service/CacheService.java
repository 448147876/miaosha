package com.zhijie.miaosha.utils.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhijie.miaosha.utils.base.Cache;
import com.zhijie.miaosha.utils.base.CacheEcacheImpl;
import com.zhijie.miaosha.utils.base.CacheRedisImpl;
import com.zhijie.miaosha.utils.base.KeyPrefix;
import com.zhijie.miaosha.utils.config.CacheConfig;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service
public class CacheService {


    static Cache cache;

    /**
     * 判断是使用ecache还是redis
     */
    static {
        if (Objects.equals(CacheConfig.USE_CACHE, CacheConfig.REDIS)) {
            cache = new CacheRedisImpl();
        } else {
            cache = new CacheEcacheImpl();
        }
    }

    /**
     * 根据前缀和key获取对象
     *
     * @param keyPrefix
     * @param key
     * @param zclass
     * @param <T>
     * @return
     */
    public <T> T get(KeyPrefix keyPrefix, String key, Class<T> zclass) {
        if (keyPrefix == null) {
            throw new RuntimeException("缓存prefix不能为空");
        }
        if (StringUtils.isBlank(key)) {
            throw new RuntimeException("缓存key不能为空");
        }
        if (zclass == null) {
            throw new RuntimeException("缓存zclass不能为空");
        }
        String jsonStr = cache.get(keyPrefix.getPrefix() + ":" + key);
        if(StringUtils.isBlank(jsonStr)){

        }
        return JSON.parseObject(jsonStr, zclass);


    }

    /**
     * 根据key获取对象
     *
     * @param prefix
     * @param key
     * @param zclass
     * @param <T>
     * @return
     */
    public <T> T get(String prefix, String key, Class<T> zclass) {
        if (prefix == null) {
            throw new RuntimeException("缓存prefix不能为空");
        }
        if (StringUtils.isBlank(key)) {
            throw new RuntimeException("缓存key不能为空");
        }
        if (zclass == null) {
            throw new RuntimeException("缓存zclass不能为空");
        }
        String jsonStr = cache.get(prefix + ":" + key);
        return JSON.parseObject(jsonStr, zclass);


    }

    /**
     * 根据key保存缓存
     *
     * @param keyPrefix
     * @param key
     * @param t
     * @param zclass
     * @param <T>
     * @return
     */
    public <T> Boolean set(KeyPrefix keyPrefix, String key, T t, Class<T> zclass) {
        if (keyPrefix == null) {
            throw new RuntimeException("缓存prefix不能为空");
        }
        if (StringUtils.isBlank(key)) {
            throw new RuntimeException("缓存key不能为空");
        }
        if (t == null) {
            throw new RuntimeException("缓存data不能为空");
        }
        if (zclass == null) {
            throw new RuntimeException("缓存zclass不能为空");
        }
        int time = keyPrefix.expireSeconds();
        String realKey = keyPrefix.getPrefix() + ":" + key;
        if (time <= 0) {
            return cache.set(realKey, JSONObject.toJSONString(t));
        } else {
            return cache.setTime(realKey, JSONObject.toJSONString(t), time);
        }
    }

    /**
     * 根据key保存缓存(有缓存有效期)
     *
     * @param prefix
     * @param key
     * @param t
     * @param time
     * @param <T>
     * @return
     */
    public <T> Boolean setTime(String prefix, String key, T t, int time) {
        if (prefix == null) {
            throw new RuntimeException("缓存prefix不能为空");
        }
        if (StringUtils.isBlank(key)) {
            throw new RuntimeException("缓存key不能为空");
        }
        if (t == null) {
            throw new RuntimeException("缓存data不能为空");
        }
        if (time < 0) {
            throw new RuntimeException("缓存time大于0");
        }
        String realKey = prefix + ":" + key;

        return cache.setTime(realKey, JSONObject.toJSONString(t), time);
    }

    /**
     * 根据key保存缓存
     *
     * @param prefix
     * @param key
     * @param t
     * @param <T>
     * @return
     */
    public <T> Boolean set(String prefix, String key, T t) {
        if (prefix == null) {
            throw new RuntimeException("缓存prefix不能为空");
        }
        if (StringUtils.isBlank(key)) {
            throw new RuntimeException("缓存key不能为空");
        }
        if (t == null) {
            throw new RuntimeException("缓存data不能为空");
        }
        String realKey = prefix + ":" + key;

        return cache.set(realKey, JSONObject.toJSONString(t));
    }

    /**
     * 根据前缀和key删除缓存
     *
     * @param keyPrefix
     * @param key
     * @return
     */
    public Boolean remove(KeyPrefix keyPrefix, String key) {
        if (keyPrefix == null) {
            throw new RuntimeException("缓存keyPrefix不能为空");
        }
        if (StringUtils.isBlank(key)) {
            throw new RuntimeException("缓存key不能为空");
        }
        String realKey = keyPrefix.getPrefix() + ":" + key;

        return cache.remove(realKey);
    }
    /**
     * 根据key删除缓存
     *
     * @param prefix
     * @param key
     * @return
     */
    public Boolean remove(String prefix, String key) {
        if (prefix == null) {
            throw new RuntimeException("缓存prefix不能为空");
        }
        if (StringUtils.isBlank(key)) {
            throw new RuntimeException("缓存key不能为空");
        }
        String realKey = prefix+ ":" + key;

        return cache.remove(realKey);
    }

    /**
     * 根据前缀删除缓存
     *
     * @param keyPrefix
     * @return
     */
    public Boolean removePrefix(KeyPrefix keyPrefix) {
        if (keyPrefix == null) {
            throw new RuntimeException("缓存keyPrefix不能为空");
        }
        String realKey = keyPrefix.getPrefix();

        return cache.removePrefix(realKey);
    }

    /**
     * 前缀删除缓存
     *
     * @param keyPrefix
     * @return
     */
    public Boolean removePrefix(String keyPrefix) {
        if (keyPrefix == null) {
            throw new RuntimeException("缓存keyPrefix不能为空");
        }
        return cache.removePrefix(keyPrefix);
    }

    /**
     * 根据前缀返回对象
     *
     * @param keyPrefix
     * @param zclass
     * @param <T>
     * @return
     */
    public <T> List<T> getByPrefix(KeyPrefix keyPrefix, Class<T> zclass) {
        if (keyPrefix == null) {
            throw new RuntimeException("缓存keyPrefix不能为空");
        }
        if (zclass == null) {
            throw new RuntimeException("缓存zclass不能为空");
        }
        List<String> tList = cache.getPrefix(keyPrefix.getPrefix());
        List<T> resultList = new LinkedList<>();
        for (String str : tList) {
            resultList.add(JSON.parseObject(str, zclass));
        }
        return resultList;
    }

    /**
     * 判断缓存是否存在
     *
     * @param keyPrefix
     * @param key
     * @return
     */
    public Boolean exit(KeyPrefix keyPrefix, String key) {
        if (keyPrefix == null) {
            throw new RuntimeException("缓存keyPrefix不能为空");
        }
        if (StringUtils.isBlank(key)) {
            throw new RuntimeException("缓存key不能为空");
        }
        String realKey = keyPrefix + ":" + key;
        Object object = cache.get(realKey);
        if (object == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 根据前缀递减
     * @param prefix
     * @param key
     * @return
     */
    public Long decr(String prefix,String key){
        if (prefix == null) {
            throw new RuntimeException("缓存prefix不能为空");
        }
        if (StringUtils.isBlank(key)) {
            throw new RuntimeException("缓存key不能为空");
        }
        return cache.decr(prefix+":"+key);

    }
    /**
     * 根据前缀递加
     * @param prefix
     * @param key
     * @return
     */
    public Long incr(String prefix,String key){
        if (prefix == null) {
            throw new RuntimeException("缓存prefix不能为空");
        }
        if (StringUtils.isBlank(key)) {
            throw new RuntimeException("缓存key不能为空");
        }
        return cache.incr(prefix+":"+key);

    }


}
