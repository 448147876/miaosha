package com.zhijie.miaosha.cacheutils.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhijie.miaosha.cacheutils.comm.KeyPrefix;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Description: 缓存service，使用缓存提升系统性能，加快开发效率
 * @auther: 童志杰
 * @date: 2018/11/14
 */
@Service
public class CacheService {


    @Autowired
    StringRedisTemplate stringRedisTemplate;


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
        String realKey = keyPrefix.getPrefix() + ":" + key;
        String jsonStr = stringRedisTemplate.opsForValue().get(realKey);

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
        String jsonStr = stringRedisTemplate.opsForValue().get(prefix + ":" + key);
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
        String realKey = keyPrefix.getPrefix() +":"+ key;
        if (time <= 0) {
            stringRedisTemplate.opsForValue().set(realKey, JSONObject.toJSONString(t));
        } else {
            stringRedisTemplate.opsForValue().set(realKey, JSONObject.toJSONString(t), time);
        }
        return true;
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
        stringRedisTemplate.opsForValue().set(realKey, JSONObject.toJSONString(t), time);
        return true;
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
        stringRedisTemplate.opsForValue().set(realKey, JSONObject.toJSONString(t));
        return true;
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
        stringRedisTemplate.delete(realKey);
        return true;
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
        String realKey = prefix + ":" + key;
        stringRedisTemplate.delete(realKey);
        return true;
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
        String value = stringRedisTemplate.opsForValue().get(realKey);
        if (value == null) {
            return false;
        } else {
            return true;
        }
    }


}
