package com.zhijie.miaosha.utils.base;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Set;


/**
 * @Description:redis缓存实现
 * @author: 童志杰
 * @Date:2018/10/18
 */
public class CacheRedisImpl implements Cache {


    private static JedisPool pool = null;


    static {
        JedisPoolConfig config = new JedisPoolConfig();
        //配置最大jedis实例数
        config.setMaxTotal(2100);
        //配置资源池最大闲置数
        config.setMaxIdle(2000);
        config.setMinIdle(2000);
        pool = new JedisPool(config, "192.168.1.150", 6379, 10000, "redis");
    }


    @Override
    public String get(String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            String value = jedis.get(key);
            return value;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

    }

    @Override
    public List<String> getPrefix(String prefix) {
        return null;
    }

    @Override
    public boolean set(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            jedis.set(key, value);
            return true;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

    }

    @Override
    public boolean setTime(String key, String value, int time) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            jedis.setex(key, time,value);
            return true;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    @Override
    public boolean exit(String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.exists(key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    @Override
    public Boolean remove(String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.del(key)>0;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    @Override
    public boolean removePrefix(String prefix) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            Set<String> keys = jedis.keys(prefix);
            int size = keys.size();
            int count = 0;
            boolean temp = false;
            for (String key : keys) {
                Long del = jedis.del(key);
                if(del>0){
                    count++;
                }
            }
            if(size == count){
                return true;
            }else{
                return false;
            }
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    @Override
    public Long decr(String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.decr(key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    @Override
    public Long incr(String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.incr(key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
