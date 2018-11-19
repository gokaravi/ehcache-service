package com.ravi.resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ravi.cache.service.CachePurgeService;

@Path("/cache/purge/v1")
public class CachePurgeResource {
	
	private static final Logger LOG = LoggerFactory.getLogger(CachePurgeResource.class);

	
	@Autowired
	private CachePurgeService cachePurgeService;

	@DELETE
	@Path("{cacheAliasName}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response clearCache(@PathParam("cacheAliasName") String cacheAliasName) {
		if(LOG.isDebugEnabled()) {
			LOG.debug("START :: removing the cache with name: {}", cacheAliasName);
		}
		cachePurgeService.purgeCache(cacheAliasName);
		String responseString = "The cache "+cacheAliasName+" is purged.";
		if(LOG.isDebugEnabled()) {
			LOG.debug("START :: removing the cache with name: {}", cacheAliasName);
		}
		return Response.status(Response.Status.OK).entity(responseString).build();
	}

	@DELETE
	@Produces({ MediaType.APPLICATION_JSON })
	public Response clearAllCache() {
		if(LOG.isDebugEnabled()) {
			LOG.debug("START :: removing all caches.");
		}
		cachePurgeService.purgeAllCache();
		String responseString = "All cache were purged.";
		if(LOG.isDebugEnabled()) {
			LOG.debug("END :: removing all caches.");
		}
		return Response.status(Response.Status.OK).entity(responseString).build();
	}

}
