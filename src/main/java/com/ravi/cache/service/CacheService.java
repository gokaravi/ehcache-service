package com.ravi.cache.service;

import com.ravi.dto.CacheData;
import com.ravi.dto.CacheDetails;

/**
 * Created by YC05R2G on 11/17/2018.
 */
public interface CacheService {
    CacheData getCacheData(String cacheName, Class cacheKeyClass, Class cacheObjectClass);
    CacheDetails getAllCacheStatistics();
}
