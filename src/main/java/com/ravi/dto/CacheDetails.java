package com.ravi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ravi Goka on 11/18/2018.
 */
public class CacheDetails implements Serializable {

    @JsonProperty("caches")
    private List<CacheData> cacheData;

    public List<CacheData> getCacheData() {
        return cacheData;
    }

    public void setCacheData(List<CacheData> cacheData) {
        this.cacheData = cacheData;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CacheDetails{");
        sb.append("cacheData=").append(cacheData);
        sb.append('}');
        return sb.toString();
    }
}
