package com.ravi.resource;

import com.ravi.cache.service.CacheStatisticsService;
import com.ravi.cache.service.TeacherCacheService;
import com.ravi.dto.Teachers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by Ravi Goka on 11/18/2018.
 */
@Path("/teacher/v1")
public class TeacherResource {

    private static final Logger LOG = LoggerFactory.getLogger(TeacherResource.class);

    @Autowired
    private TeacherCacheService teacherCacheService;

    @Autowired
    private CacheStatisticsService cacheStatisticsService;

    @GET
    @Produces("application/json")
    public Teachers getAllTeachers() {
        if(LOG.isDebugEnabled()) {
            LOG.debug("START :: Getting all teachers");
        }
        LOG.info("Inside health check resource GET method");
        Teachers teachers = teacherCacheService.getAllTeachers();
        if(LOG.isDebugEnabled()) {
            LOG.debug("The teachers list: {}", teachers);
            LOG.debug("END :: Getting all teachers");
        }
        return teachers;
    }
}
