package com.ravi.cache.service.impl;

import static com.ravi.constants.CacheConstants.CACHE_AVERAGE_GET_TIME;
import static com.ravi.constants.CacheConstants.CACHE_AVERAGE_PUT_TIME;
import static com.ravi.constants.CacheConstants.CACHE_AVERAGE_REMOVE_TIME;
import static com.ravi.constants.CacheConstants.CACHE_EVICTIONS;
import static com.ravi.constants.CacheConstants.CACHE_GETS;
import static com.ravi.constants.CacheConstants.CACHE_HITS;
import static com.ravi.constants.CacheConstants.CACHE_HIT_PERCENTAGE;
import static com.ravi.constants.CacheConstants.CACHE_MISSES;
import static com.ravi.constants.CacheConstants.CACHE_MISS_PERCENTAGE;
import static com.ravi.constants.CacheConstants.CACHE_PUTS;
import static com.ravi.constants.CacheConstants.CACHE_REMOVALS;
import static com.ravi.constants.CacheConstants.CACHE_STATISTICS_BEAN;

import java.lang.management.ManagementFactory;
import java.util.Iterator;

import javax.cache.Cache;
import javax.cache.CacheException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ravi.dto.CacheStatistics;

/**
 * Created by Ravi Goka on 11/18/2018.
 */
public class BaseCacheStatisticsServiceImpl {

    private static final Logger LOG = LoggerFactory.getLogger(BaseCacheStatisticsServiceImpl.class);

    protected CacheStatistics getStatistics(Cache<? extends Object, ? extends Object> cache) {
        CacheStatistics cacheStatistics = null;
        try {
            ObjectName objectName = getJMXObjectName(cache);
            MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
            // retrieving the cache statistics from MBeanServer.
            cacheStatistics = mapStatistics(mBeanServer, objectName);
        }
        catch (Exception ex) {
            LOG.error("ERROR :: Exception occurred while getting the statistics for cache {} and the exception {}", cache, ex);
            throw new RuntimeException(ex);
        }
        return cacheStatistics;
    }
    private ObjectName getJMXObjectName(Cache<? extends Object, ? extends Object> cache){
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

        // Refer to org.ehcache.jsr107.Eh107CacheStatisticsMXBean.Eh107CacheStatisticsMXBean(String, URI, StatisticsService)
        // and org.ehcache.jsr107.Eh107MXBean.Eh107MXBean(String, URI, String)
        String cacheManagerName = sanitize(cache.getCacheManager().getURI().toString());
        String cacheName = sanitize(cache.getName());
        ObjectName objectName = null;
        try {
            objectName = new ObjectName(
                    "javax.cache:type=" + CACHE_STATISTICS_BEAN + ",CacheManager=" + cacheManagerName + ",Cache=" + cacheName);
        }
        catch (MalformedObjectNameException e) {
            throw new CacheException(e);
        }

        if(!mBeanServer.isRegistered(objectName)){
            throw new CacheException("No MBean found with ObjectName => " + objectName.getCanonicalName());
        }

        return objectName;
    }

    private String sanitize(String string) {
        return ((string == null) ? "" : string.replaceAll(",|:|=|\n", "."));
    }

    public <K extends Object, V extends Object> long getSize(Cache<K, V> cache) {
        Iterator<Cache.Entry<K, V>> itr = cache.iterator();
        long count = 0;
        while(itr.hasNext()){
            itr.next();
            count++;
        }
        return count;
    }

    public <K extends Object, V extends Object> String dump(Cache<K, V> cache) {
        Iterator<Cache.Entry<K, V>> itr = cache.iterator();
        StringBuffer b = new StringBuffer();
        while(itr.hasNext()){
            Cache.Entry<K, V> entry = itr.next();
            b.append(entry.getKey() + "=" + entry.getValue() + "\n");
        }
        return b.toString();
    }

    private CacheStatistics mapStatistics(MBeanServer mBeanServer, ObjectName objectName){
        CacheStatistics cacheStatistics = new CacheStatistics();
        try {
            cacheStatistics.setCacheHits((long)mBeanServer.getAttribute(objectName, CACHE_HITS));
            cacheStatistics.setCacheHitPercentage((float)mBeanServer.getAttribute(objectName, CACHE_HIT_PERCENTAGE));
            cacheStatistics.setCacheMisses((long)mBeanServer.getAttribute(objectName, CACHE_MISSES));
            cacheStatistics.setCacheMissPercentage((float)mBeanServer.getAttribute(objectName, CACHE_MISS_PERCENTAGE));
            cacheStatistics.setCacheGets((long)mBeanServer.getAttribute(objectName, CACHE_GETS));
            cacheStatistics.setCachePuts((long)mBeanServer.getAttribute(objectName, CACHE_PUTS));
            cacheStatistics.setCacheRemovals((long)mBeanServer.getAttribute(objectName, CACHE_REMOVALS));
            cacheStatistics.setCacheEvictions((long)mBeanServer.getAttribute(objectName, CACHE_EVICTIONS));
            cacheStatistics.setAverageGetTime((float)mBeanServer.getAttribute(objectName, CACHE_AVERAGE_GET_TIME));
            cacheStatistics.setAveragePutTime((float)mBeanServer.getAttribute(objectName, CACHE_AVERAGE_PUT_TIME));
            cacheStatistics.setAverageRemoveTime((float)mBeanServer.getAttribute(objectName, CACHE_AVERAGE_REMOVE_TIME));
        }
        catch (Exception ex){
            LOG.error("Exception occurred while reading the cache statistics from Eh107CacheStatisticsMXBean", ex);
        }
        return cacheStatistics;
    }
}
