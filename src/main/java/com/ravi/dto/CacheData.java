package com.ravi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by YC05R2G on 11/17/2018.
 */
public class CacheData implements Serializable{
    private String name;
    private boolean enabled;
    @JsonProperty("statistics")
    private CacheStatistics cacheStatistics;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public CacheStatistics getCacheStatistics() {
        return cacheStatistics;
    }

    public void setCacheStatistics(CacheStatistics cacheStatistics) {
        this.cacheStatistics = cacheStatistics;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CacheData{");
        sb.append("name='").append(name).append('\'');
        sb.append(", enabled=").append(enabled);
        sb.append(", cacheStatistics=").append(cacheStatistics);
        sb.append('}');
        return sb.toString();
    }
}
