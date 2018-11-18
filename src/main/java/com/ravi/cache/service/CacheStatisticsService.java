package com.ravi.cache.service;

import com.ravi.dto.CacheData;

import javax.cache.Cache;

/**
 * Created by YC05R2G on 11/17/2018.
 */
public interface CacheStatisticsService {

    CacheData getStatistics(String cacheAliasName);
}
