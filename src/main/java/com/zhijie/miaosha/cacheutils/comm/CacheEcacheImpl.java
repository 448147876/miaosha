package com.zhijie.miaosha.cacheutils.comm;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.List;


/**
 * @Description:ecache缓存实现
 * @author: 童志杰
 * @Date:2018/10/18
 */
public class CacheEcacheImpl implements Cache {

    private static CacheManager cacheManager;
    private static net.sf.ehcache.Cache cache;
    private static final String CACHE_NAME = "cacheName";

    static {
        cacheManager = CacheManager.create();
        cache = new net.sf.ehcache.Cache(CACHE_NAME, 0, false, true, 0, 0);
        cacheManager.addCache(cache);
    }


    @Override
    public String get(String key) {
        Element getGreeting = cache.get(key);
        if (getGreeting != null) {
            return (String) getGreeting.getObjectValue();
        } else {
            return null;
        }
    }

    @Override
    public List<String> getPrefix(String prefix) {
        List<String> listResult = new LinkedList<>();
        List<?> keys = cache.getKeys();
        for (Object obj : keys) {
            String keySrc = obj.toString();
            if (StringUtils.startsWith(keySrc, prefix)) {
                Element getGreeting = cache.get(keySrc);
                if (getGreeting != null) {
                    String value = (String) getGreeting.getObjectValue();
                    listResult.add(value);
                }
            }
        }
        return listResult;
    }

    @Override
    public boolean set(String key, String value) {
        cache.put(new Element(key, value));
        return true;
    }

    @Override
    public boolean setTime(String key, String value, int time) {
        Element element = new Element(key, value);
        element.setTimeToLive(time);
        cache.put(element);
        return true;
    }

    @Override
    public boolean exit(String key) {
        Element getGreeting = cache.get(key);
        if (getGreeting != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean remove(String key) {
        return cache.removeQuiet(key);
    }

    @Override
    public boolean removePrefix(String prefix) {
        List<?> keys = cache.getKeys();
        for (Object obj : keys) {
            String keySrc = obj.toString();
            if (StringUtils.startsWith(keySrc, prefix)) {
                cache.removeQuiet(keySrc);
            }
        }
        return true;
    }

    @Override
    public Long decr(String key) {
        Element getGreeting = cache.get(key);
        if (getGreeting != null) {
            Long zlong  = (Long) getGreeting.getObjectValue();
            zlong--;
            cache.put(new Element(key, zlong));
            return zlong;
        }
        return null;
    }

    @Override
    public Long incr(String key) {
        Element getGreeting = cache.get(key);
        if (getGreeting != null) {
            Long zlong  = (Long) getGreeting.getObjectValue();
            zlong++;
            cache.put(new Element(key, zlong));
            return zlong;
        }
        return null;
    }
}
