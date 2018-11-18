package com.ravi.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.ravi.cache.service.CacheStatisticsService;
import com.ravi.dto.CacheData;
import com.ravi.dto.CacheStatistics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import com.ravi.cache.service.UserCacheService;
import com.ravi.dto.Users;

import static com.ravi.constants.CacheConstants.USER_CACHE_ALIAS;

@Path("/user/v1")
public class UserResource {

	private static final Logger LOG = LoggerFactory.getLogger(UserResource.class);

	@Autowired
	private UserCacheService userCacheService;

	@Autowired
	private CacheStatisticsService cacheStatisticsService;

	@GET
	@Produces("application/json")
	public Users getAllUsers() {
		LOG.info("Inside health check resource GET method");
		Users users = userCacheService.getAllUsers();
		LOG.info("The users list: " + users);
		return users;
	}


	@GET
	@Path("/stats")
	@Produces("application/json")
	public Response getStatistics() {
		LOG.info("Inside health check resource GET method");
		CacheData cacheData = cacheStatisticsService.getStatistics(USER_CACHE_ALIAS);
		LOG.info("The users list: " + cacheData);
		return Response.status(Response.Status.OK).entity(cacheData).build();
	}
}
