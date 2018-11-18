package com.ravi.cache.service.impl;

import com.ravi.cache.service.TeacherCacheService;
import com.ravi.cache.service.TeacherService;
import com.ravi.dto.Teachers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.cache.Cache;
import javax.cache.CacheManager;

import static com.ravi.constants.CacheConstants.TEACHER_CACHE_ALIAS;
import static com.ravi.constants.CacheConstants.TEACHER_CACHE_KEY;

/**
 * Created by Ravi Goka on 11/18/2018.
 */

@Component
public class TeacherCacheServiceImpl implements TeacherCacheService {
    private static final Logger LOG = LoggerFactory.getLogger(TeacherCacheServiceImpl.class);

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CacheManager cacheManager;

    @Override
    public Teachers getAllTeachers(){
        if(LOG.isDebugEnabled()){
            LOG.debug("START :: Getting all teachers");
        }
        Teachers teachers;
        Cache<String, Object> teachersCache = cacheManager.getCache(TEACHER_CACHE_ALIAS, String.class, Object.class);
        teachers = (Teachers)teachersCache.get(TEACHER_CACHE_KEY);

        if(null == teachers){
            if(LOG.isDebugEnabled()){
                LOG.debug("Data Not found in Cache: {}", teachers);
                LOG.debug("Reading user information from service/DB");
            }
            teachers = teacherService.getAllTeachers();
            teachersCache.put(TEACHER_CACHE_KEY, teachers);
        }
        if(LOG.isDebugEnabled()){
            LOG.debug("END :: Getting all teachers: {}", teachers);
        }
        return teachers;
    }
}
