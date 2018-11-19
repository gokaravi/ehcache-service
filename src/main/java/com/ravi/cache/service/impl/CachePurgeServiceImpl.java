/**
 * 
 */
package com.ravi.cache.service.impl;

import javax.cache.Cache;
import javax.cache.CacheManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ravi.cache.service.CachePurgeService;

/**
 * @author Ravi Goka
 * @email ravikumargoka@gmail.com
 * @Nov 18, 2018
 * 
 */
@Component
public class CachePurgeServiceImpl implements CachePurgeService {

	private static final Logger LOG = LoggerFactory.getLogger(CachePurgeServiceImpl.class);

	@Autowired
	private CacheManager cacheManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ravi.cache.service.CachePurgeService#purgeCache(java.lang.String)
	 */
	@Override
	public void purgeCache(String cacheAliasName) {
		if(LOG.isDebugEnabled()) {
			LOG.debug("START :: removing cache: {}", cacheAliasName);
		}
		Cache<String, Object> cache = cacheManager.getCache(cacheAliasName, String.class, Object.class);
		if(null != cache) {
			cache.removeAll();
		}
		if(LOG.isDebugEnabled()) {
			LOG.debug("START :: removing cache: {}", cacheAliasName);
		}
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ravi.cache.service.CachePurgeService#purgeAllCache()
	 */
	@Override
	public void purgeAllCache() {
		if(LOG.isDebugEnabled()) {
			LOG.debug("START :: removing all caches.");
		}
		Iterable<String> allCacheNames = cacheManager.getCacheNames();
		if (null != allCacheNames) {
			for (String cacheAliasName : allCacheNames) {
				Cache<String, Object> cache = cacheManager.getCache(cacheAliasName, String.class, Object.class);
				if(null != cache) {
					cache.removeAll();
				}
			}
		}
		if(LOG.isDebugEnabled()) {
			LOG.debug("END :: removing all caches.");
		}
	}

}
