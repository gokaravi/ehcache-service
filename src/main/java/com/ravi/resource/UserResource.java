package com.ravi.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ravi.cache.service.UserCacheService;
import com.ravi.dto.Users;

/**
 * Created by Ravi Goka on 11/18/2018.
 */
@Path("/user/v1")
public class UserResource {

	private static final Logger LOG = LoggerFactory.getLogger(UserResource.class);

	@Autowired
	private UserCacheService userCacheService;

	@GET
	@Produces("application/json")
	public Users getAllUsers() {
		if(LOG.isDebugEnabled()) {
			LOG.debug("START :: Getting all users");
		}
		Users users = userCacheService.getAllUsers();
		if(LOG.isDebugEnabled()) {
			LOG.info("The users list: {}", users);
			LOG.debug("END :: Getting all users");
		}
		return users;
	}
}
