package com.ravi;

import java.net.URI;

import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.Resource;

import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.spi.CachingProvider;


/**
 * Created by Ravi Goka on 11/18/2018.
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackages = {"com.ravi"})
public class AppConfig extends SpringBootServletInitializer {

    private static final Logger LOG = LoggerFactory.getLogger(AppConfig.class);

    @Value("classpath:ehcache.xml")
    private Resource cacheResource;

    public static void main(String[] args) {
        new AppConfig().configure(new SpringApplicationBuilder(AppConfig.class)).run(args);
    }

    @Bean
    ResourceConfig resourceConfig() {
        return new ResourceConfig().packages("com.ravi");
    }

    @Bean(name="cacheManager")
    public CacheManager cacheManager() {
        CacheManager cacheManager = null;
        try {
            URI uri = cacheResource.getURI();
            CachingProvider cachingProvider = Caching.getCachingProvider();
            cacheManager = cachingProvider.getCacheManager(uri, getClass().getClassLoader());
        }
        catch(Exception ioe){
            LOG.error("ERROR :: Error occurred while initializing cache manager. Cannot load the preferences-ehcache.xml file.", ioe);
        }
        return cacheManager;
    }

}
