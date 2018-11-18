package com.ravi.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ravi.cache.service.TeacherCacheService;
import com.ravi.dto.Teachers;

/**
 * Created by Ravi Goka on 11/18/2018.
 */
@Path("/teacher/v1")
public class TeacherResource {

    private static final Logger LOG = LoggerFactory.getLogger(TeacherResource.class);

    @Autowired
    private TeacherCacheService teacherCacheService;

    @GET
    @Produces("application/json")
    public Teachers getAllTeachers() {
        if(LOG.isDebugEnabled()) {
            LOG.debug("START :: Getting all teachers");
        }
        Teachers teachers = teacherCacheService.getAllTeachers();
        if(LOG.isDebugEnabled()) {
            LOG.debug("The teachers list: {}", teachers);
            LOG.debug("END :: Getting all teachers");
        }
        return teachers;
    }
}
