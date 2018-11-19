package com.ravi.cache.service;

import com.ravi.dto.CacheData;
import com.ravi.dto.CacheDetails;

/**
 * Created by Ravi Goka on 11/17/2018.
 */
public interface CacheStatisticsService {
	
	/**
	 * Method to get the statistics of a given cache
	 * @param cacheAliasName
	 * @param cacheKeyClass
	 * @param cacheObjectClass
	 * @return CacheData
	 */
    CacheData getStatistics(String cacheAliasName, Class cacheKeyClass, Class cacheObjectClass);

    /**
     * Method to get the statistics of all the caches in the application
     * @return CacheDetails
     */
    CacheDetails getAllCacheStatistics();

}
