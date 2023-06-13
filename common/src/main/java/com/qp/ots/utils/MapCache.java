package com.qp.ots.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * map缓存
 *
 * @author Listen.Li
 */
public class MapCache {
    private static final MapCache INS = new MapCache();
    private Map<String, Object> cachePool;

    private MapCache() {
        cachePool = new ConcurrentHashMap<>();
    }

    public static MapCache getInstance() {
        return INS;
    }

    public Object get(String key) {
        return cachePool.get(key);
    }

    public void set(String key, Object value) {
        cachePool.put(key, value);
    }

    public void del(String key) {
        cachePool.remove(key);
    }

    public List getAll(){
        return new ArrayList(cachePool.values());
    }

    public void clean() {
        cachePool.clear();
    }
}
