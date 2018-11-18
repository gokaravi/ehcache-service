package com.ravi.cache.service;

import com.ravi.dto.CacheData;
import com.ravi.dto.CacheDetails;

import javax.cache.Cache;

/**
 * Created by YC05R2G on 11/17/2018.
 */
public interface CacheStatisticsService {

    CacheData getStatistics(String cacheAliasName, Class cacheKeyClass, Class cacheObjectClass);

    CacheDetails getAllCacheStatistics();

}
