package com.ravi.cache.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ravi.cache.service.UserCacheService;
import com.ravi.cache.service.UserService;
import com.ravi.dto.Users;

import javax.cache.Cache;
import javax.cache.CacheManager;

import static com.ravi.constants.CacheConstants.USER_CACHE_ALIAS;
import static com.ravi.constants.CacheConstants.USER_CACHE_KEY;

@Component
public class UserCacheServiceImpl implements UserCacheService {
	private static final Logger LOG = LoggerFactory.getLogger(UserCacheServiceImpl.class);


    @Autowired
    private UserService userService;

    @Autowired
    private CacheManager cacheManager;

    @Override
    public Users getAllUsers(){
        Users users;
        Cache<String, Users> usersCache = cacheManager.getCache(USER_CACHE_ALIAS, String.class, Users.class);
        users = usersCache.get(USER_CACHE_KEY);
		LOG.info("Reading user information from Cache :: {}", users);
        if(null == users){
    		LOG.info("Data Not found in Cache", users);
        	users = userService.getUsers();
        	LOG.info("Reading user information from DB");
            usersCache.put(USER_CACHE_KEY, users);
        }
        return users;
    }

}
