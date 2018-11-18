package com.ravi.cache.service.impl;

import com.ravi.cache.service.CacheService;
import com.ravi.cache.service.CacheStatisticsService;
import com.ravi.dto.CacheData;
import com.ravi.dto.CacheDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Ravi Goka on 11/17/2018.
 */
@Component
public class CacheServiceImpl implements CacheService {

    @Autowired
    private CacheStatisticsService cacheStatisticsService;

    @Override
    public CacheData getCacheData(String cacheName, Class cacheKeyClass, Class cacheObjectClass){
     return cacheStatisticsService.getStatistics(cacheName, cacheKeyClass, cacheObjectClass);
    }

    @Override
    public CacheDetails getAllCacheStatistics(){
        return cacheStatisticsService.getAllCacheStatistics();
    }
}
