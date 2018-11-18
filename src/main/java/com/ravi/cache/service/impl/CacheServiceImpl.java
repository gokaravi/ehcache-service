package com.ravi.cache.service.impl;

import com.ravi.cache.service.CacheService;
import com.ravi.cache.service.CacheStatisticsService;
import com.ravi.dto.CacheData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by YC05R2G on 11/17/2018.
 */
@Component
public class CacheServiceImpl implements CacheService {

    @Autowired
    private CacheStatisticsService cacheStatisticsService;

    @Override
    public CacheData getCacheData(String cacheName){
     return cacheStatisticsService.getStatistics(cacheName);
    }

}
