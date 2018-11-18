package com.ravi.cache.service.impl;

import static com.ravi.constants.CacheConstants.USER_CACHE_ALIAS;
import static com.ravi.constants.CacheConstants.USER_CACHE_KEY;

import javax.cache.Cache;
import javax.cache.CacheManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ravi.cache.service.UserCacheService;
import com.ravi.cache.service.UserService;
import com.ravi.dto.Users;

@Component
public class UserCacheServiceImpl implements UserCacheService {
	private static final Logger LOG = LoggerFactory.getLogger(UserCacheServiceImpl.class);


    @Autowired
    private UserService userService;

    @Autowired
    private CacheManager cacheManager;

    @Override
    public Users getAllUsers(){
        if(LOG.isDebugEnabled()){
            LOG.debug("START :: Getting all users");
        }
        Users users;
        Cache<String, Object> usersCache = cacheManager.getCache(USER_CACHE_ALIAS, String.class, Object.class);
        users = (Users)usersCache.get(USER_CACHE_KEY);
        if(null == users){
            if(LOG.isDebugEnabled()){
                LOG.debug("Data Not found in Cache", users);
                LOG.debug("Reading user information from service/DB");
            }
            users = userService.getUsers();
            usersCache.put(USER_CACHE_KEY, users);
        }
        if(LOG.isDebugEnabled()){
            LOG.debug("END :: Getting all users: {}", users);
        }
        return users;
    }

}
