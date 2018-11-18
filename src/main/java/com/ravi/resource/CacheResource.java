package com.ravi.resource;

import static com.ravi.constants.CacheConstants.TEACHER_CACHE_ALIAS;
import static com.ravi.constants.CacheConstants.USER_CACHE_ALIAS;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ravi.cache.service.CacheStatisticsService;
import com.ravi.dto.CacheData;
import com.ravi.dto.CacheDetails;

/**
 * Created by Ravi Goka on 11/18/2018.
 */
@Path("/cache/v1")
public class CacheResource {

	private static final Logger LOG = LoggerFactory.getLogger(CacheResource.class);

	@Autowired
	private CacheStatisticsService cacheStatisticsService;

	@GET
	@Path("/users")
	@Produces("application/json")
	public Response getUserCache() {
		if (LOG.isDebugEnabled()) {
			LOG.debug("START :: Getting user cache");
		}
		CacheData cacheData = cacheStatisticsService.getStatistics(USER_CACHE_ALIAS, String.class, Object.class);
		if (LOG.isDebugEnabled()) {
			LOG.debug("The users list: {} ", cacheData);
			LOG.debug("END :: Getting user cache");
		}
		return Response.status(Response.Status.OK).entity(cacheData).build();
	}

	@GET
	@Path("/teachers")
	@Produces("application/json")
	public Response getTeacherCache() {
		if (LOG.isDebugEnabled()) {
			LOG.debug("START :: Getting teacher cache");
		}
		CacheData cacheData = cacheStatisticsService.getStatistics(TEACHER_CACHE_ALIAS, String.class, Object.class);
		if (LOG.isDebugEnabled()) {
			LOG.debug("The teachers list: {}", cacheData);
			LOG.debug("END :: Getting teacher cache");
		}
		return Response.status(Response.Status.OK).entity(cacheData).build();
	}

	@GET
	@Path("/all")
	@Produces("application/json")
	public Response getAllCache() {
		if (LOG.isDebugEnabled()) {
			LOG.debug("START :: Getting all the cache");
		}
		CacheDetails cacheDetails = cacheStatisticsService.getAllCacheStatistics();
		if (LOG.isDebugEnabled()) {
			LOG.debug("The all cache list: {}", cacheDetails);
			LOG.debug("END :: Getting all the cache");
		}
		return Response.status(Response.Status.OK).entity(cacheDetails).build();
	}

}
