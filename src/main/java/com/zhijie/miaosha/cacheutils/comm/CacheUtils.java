//package com.zhijie.miaosha.cacheutils.base;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.zhijie.miaosha.cacheutils.config.CacheConfig;
//import org.apache.commons.lang3.StringUtils;
//
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Objects;
//
//
///**
// * @Description:缓存工具
// * @author: 童志杰
// * @Date:2018/10/10
// */
//public class CacheUtils {
//
//    static Cache cache;
//
//    /**
//     * 判断是使用ecache还是redis
//     */
//    static {
//        if (Objects.equals(CacheConfig.USE_CACHE, CacheConfig.REDIS)) {
//            cache = new CacheRedisImpl();
//        } else {
//            cache = new CacheEcacheImpl();
//        }
//    }
//
//    /**
//     * 根据key和class查询对象
//     *
//     * @param prefix
//     * @param key
//     * @param zclass
//     * @param <T>
//     * @return
//     */
//    public static <T> T get(KeyPrefix prefix, String key, Class<T> zclass) {
//        if (prefix == null) {
//            throw new RuntimeException("缓存prefix不能为空");
//        }
//        if (StringUtils.isBlank(key)) {
//            throw new RuntimeException("缓存key不能为空");
//        }
//        if (zclass == null) {
//            throw new RuntimeException("缓存zclass不能为空");
//        }
//        String jsonStr = cache.get(prefix, key);
//        return JSON.parseObject(jsonStr, zclass);
//    }
//
//
//    /**
//     * 根据key查询字符串
//     *
//     * @param prefix
//     * @param key
//     * @return
//     */
//    public static String get(KeyPrefix prefix, String key) {
//        if (prefix == null) {
//            throw new RuntimeException("缓存prefix不能为空");
//        }
//        if (StringUtils.isBlank(key)) {
//            throw new RuntimeException("缓存key不能为空");
//        }
//        return cache.get(prefix, key);
//    }
//
//    /**
//     * 根据前缀和class查询对象s
//     *
//     * @param prefix
//     * @param zclass
//     * @param <T>
//     * @return
//     */
//    public static <T> List<T> getByPrefix(KeyPrefix prefix, Class<T> zclass) {
//        if (prefix == null) {
//            throw new RuntimeException("缓存prefix不能为空");
//        }
//        if (zclass == null) {
//            throw new RuntimeException("缓存zclass不能为空");
//        }
//        List<String> list = cache.getPrefix(prefix);
//        List<T> listT = new LinkedList<>();
//        for (String str : list) {
//            listT.add(JSON.parseObject(str, zclass));
//        }
//        return listT;
//    }
//
//    /**
//     * 根据key和字符串保存字符串
//     *
//     * @param prefix
//     * @param key
//     * @param data
//     * @return
//     */
//    public static boolean set(KeyPrefix prefix, String key, String data) {
//        if (prefix == null) {
//            throw new RuntimeException("缓存prefix不能为空");
//        }
//        if (StringUtils.isBlank(key)) {
//            throw new RuntimeException("缓存key不能为空");
//        }
//        if (data == null) {
//            throw new RuntimeException("缓存data不能为空");
//        }
//        return cache.set(prefix, key, data);
//    }
//
//    /**
//     * 根据key和对象和class保存对象
//     *
//     * @param prefix
//     * @param key
//     * @param t
//     * @param zclass
//     * @param <T>
//     * @return
//     */
//    public static <T> boolean set(KeyPrefix prefix, String key, T t, Class<T> zclass) {
//        if (prefix == null) {
//            throw new RuntimeException("缓存prefix不能为空");
//        }
//        if (StringUtils.isBlank(key)) {
//            throw new RuntimeException("缓存key不能为空");
//        }
//        if (t == null) {
//            throw new RuntimeException("缓存t不能为空");
//        }
//        if (zclass == null) {
//            throw new RuntimeException("缓存zclass不能为空");
//        }
//        String jsonStr = JSONObject.toJSONString(t);
//
//        return cache.set(prefix, key, jsonStr);
//
//    }
//
//    /**
//     * 保存有有效期的字符串
//     *
//     * @param prefix
//     * @param key
//     * @param data
//     * @param time
//     * @return
//     */
//    public static boolean setByTime(KeyPrefix prefix, String key, String data, Long time) {
//        if (prefix == null) {
//            throw new RuntimeException("缓存prefix不能为空");
//        }
//        if (StringUtils.isBlank(key)) {
//            throw new RuntimeException("缓存key不能为空");
//        }
//        if (data == null) {
//            throw new RuntimeException("缓存data不能为空");
//        }
//        if (time == null) {
//            throw new RuntimeException("缓存time不能为空");
//        }
//        return cache.setTime(prefix, key, data, time);
//    }
//
//    /**
//     * 保存有缓存期的对象
//     *
//     * @param prefix
//     * @param key
//     * @param t
//     * @param zclass
//     * @param time
//     * @param <T>
//     * @return
//     */
//    public static <T> boolean setByTime(KeyPrefix prefix, String key, T t, Class<T> zclass, Long time) {
//        if (prefix == null) {
//            throw new RuntimeException("缓存prefix不能为空");
//        }
//        if (StringUtils.isBlank(key)) {
//            throw new RuntimeException("缓存key不能为空");
//        }
//        if (t == null) {
//            throw new RuntimeException("缓存t不能为空");
//        }
//        if (zclass == null) {
//            throw new RuntimeException("缓存zclass不能为空");
//        }
//        if (time == null) {
//            throw new RuntimeException("缓存time不能为空");
//        }
//        String jsonStr = JSONObject.toJSONString(t);
//        return cache.setTime(prefix, key, jsonStr, time);
//    }
//
//    /**
//     * 判断是否存在
//     *
//     * @param prefix
//     * @param key
//     * @return
//     */
//    public static boolean exit(KeyPrefix prefix, String key) {
//        if (prefix == null) {
//            throw new RuntimeException("缓存prefix不能为空");
//        }
//        if (StringUtils.isBlank(key)) {
//            throw new RuntimeException("缓存key不能为空");
//        }
//        Object object = cache.get(prefix, key);
//        if (object == null) {
//            return false;
//        } else {
//            return true;
//        }
//    }
//
//    /**
//     * 根据key和class删除对象，并返回该对象
//     *
//     * @param prefix
//     * @param key
//     * @param zclass
//     * @param <T>
//     * @return
//     */
//    public static <T> T remove(KeyPrefix prefix, String key, Class<T> zclass) {
//        if (prefix == null) {
//            throw new RuntimeException("缓存prefix不能为空");
//        }
//        if (StringUtils.isBlank(key)) {
//            throw new RuntimeException("缓存key不能为空");
//        }
//        if (zclass == null) {
//            throw new RuntimeException("缓存zclass不能为空");
//        }
//        String str = cache.remove(prefix, key);
//        return JSON.parseObject(str, zclass);
//    }
//
//    /**
//     * 根据key删除字符串，并返回该字符串
//     *
//     * @param prefix
//     * @param key
//     * @return
//     */
//    public static String remove(KeyPrefix prefix, String key) {
//        if (prefix == null) {
//            throw new RuntimeException("缓存prefix不能为空");
//        }
//        if (StringUtils.isBlank(key)) {
//            throw new RuntimeException("缓存key不能为空");
//        }
//        return cache.remove(prefix, key);
//    }
//
//    /**
//     * 根据前缀删除缓存
//     *
//     * @param prefix
//     * @return
//     */
//    public boolean removePrefix(KeyPrefix prefix) {
//        if (prefix == null) {
//            throw new RuntimeException("缓存prefix不能为空");
//        }
//
//        return cache.removePrefix(prefix);
//    }
//
//    /**
//     * 根据key递减
//     *
//     * @param prefix
//     * @param key
//     * @return
//     */
//    public Long decr(KeyPrefix prefix, String key) {
//        if (prefix == null) {
//            throw new RuntimeException("缓存prefix不能为空");
//        }
//        if (StringUtils.isBlank(key)) {
//            throw new RuntimeException("缓存key不能为空");
//        }
//        return cache.decr(prefix, key);
//    }
//
//
//    /**
//     * 根据key递加
//     *
//     * @param prefix
//     * @param key
//     * @return
//     */
//    public Long incr(KeyPrefix prefix, String key) {
//        if (prefix == null) {
//            throw new RuntimeException("缓存prefix不能为空");
//        }
//        if (StringUtils.isBlank(key)) {
//            throw new RuntimeException("缓存key不能为空");
//        }
//        return cache.incr(prefix, key);
//    }
//
//
//}
