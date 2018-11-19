package com.ravi.cache.service.impl;

import com.ravi.cache.service.CacheStatisticsService;
import com.ravi.dto.CacheData;
import com.ravi.dto.CacheDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.cache.Cache;
import javax.cache.CacheManager;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Ravi Goka on 11/17/2018.
 */
@Component
public class CacheStatisticsServiceImpl extends BaseCacheStatisticsServiceImpl implements CacheStatisticsService{

    private static final Logger LOG = LoggerFactory.getLogger(CacheStatisticsServiceImpl.class);

    @Autowired
    private CacheManager cacheManager;

    @Override
    public CacheData getStatistics(String cacheAliasName, Class cacheKeyClass, Class cacheObjectClass) {
        if(LOG.isDebugEnabled()) {
            LOG.debug("START :: Getting the statistics for cache: {}, key class: {} and cache object class: {}", cacheAliasName, cacheKeyClass, cacheObjectClass);
        }
        CacheData cacheData = new CacheData();
        cacheData.setName(cacheAliasName);
        Cache<String, Object> usersCache = cacheManager.getCache(cacheAliasName, cacheKeyClass, cacheObjectClass);
        if(null != usersCache) {
        cacheData.setEnabled(!usersCache.isClosed());	
        }
        cacheData.setCacheStatistics(getStatistics(usersCache));
        if(LOG.isDebugEnabled()) {
            LOG.debug("The cache data: {}", cacheData);
            LOG.debug("END :: Getting the statistics for cache: {}, key class: {} and cache object class: {}", cacheAliasName, cacheKeyClass, cacheObjectClass);
        }
        return cacheData;
    }

    @Override
    public CacheDetails getAllCacheStatistics(){
        if(LOG.isDebugEnabled()) {
            LOG.debug("START :: Getting the statistics for all the cache");
        }
       CacheDetails cacheDetails = new CacheDetails();
        List<CacheData> cacheDataList = null;
        Iterable<String> allCacheNames = cacheManager.getCacheNames();
        if(null != allCacheNames){
            cacheDataList = new ArrayList<>();
            for(String cacheAliasName : allCacheNames){
                Cache<String, Object> cacheObject =  cacheManager.getCache(cacheAliasName, String.class, Object.class);
                CacheData cacheData = new CacheData();
                cacheData.setName(cacheAliasName);
                if(null != cacheObject) {
                    cacheData.setEnabled(!cacheObject.isClosed());	
                    }
                cacheData.setCacheStatistics(getStatistics(cacheObject));
                cacheDataList.add(cacheData);
            }
        }
        if(null != cacheDataList && cacheDataList.size() > 0) {
            cacheDetails.setCacheData(cacheDataList);
        }
        if(LOG.isDebugEnabled()) {
            LOG.debug("The cache details: {}", cacheDetails);
            LOG.debug("END :: Getting the statistics for all the cache");
        }
        return cacheDetails;
    }

}
