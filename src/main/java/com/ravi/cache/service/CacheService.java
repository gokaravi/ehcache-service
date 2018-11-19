package com.ravi.cache.service;

import com.ravi.dto.CacheData;
import com.ravi.dto.CacheDetails;

/**
 * Created by Ravi Goka on 11/17/2018.
 */
public interface CacheService {
	/**
	 * Method to get the cache data of a give cache
	 * @param cacheName
	 * @param cacheKeyClass
	 * @param cacheObjectClass
	 * @return cacheData
	 */
    CacheData getCacheData(String cacheName, Class cacheKeyClass, Class cacheObjectClass);
    
    /**
     * Method to get the statistics of all caches
     * @return cacheDetails
     */
    CacheDetails getAllCacheStatistics();
}
