package com.ravi.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serializable;

/**
 * Created by Ravi Goka on 11/17/2018.
 */
@JsonPropertyOrder({"averageGetTime", "averagePutTime", "averageRemoveTime", "cacheEvictions", "cacheGets", "cacheHitPercentage", "cacheHits", "cacheMisses", "cacheMissPercentage", "cachePuts", "cacheRemovals"})
@JsonRootName("statistics")
public class CacheStatistics implements Serializable{

  private float averageGetTime;
  private float averagePutTime;
  private float averageRemoveTime;
  private long cacheEvictions;
  private long cacheGets;
  private float cacheHitPercentage;
  private long cacheHits;
  private long cacheMisses;
  private float cacheMissPercentage;
  private long cachePuts;
  private long cacheRemovals;

    public float getAverageGetTime() {
        return averageGetTime;
    }

    public void setAverageGetTime(float averageGetTime) {
        this.averageGetTime = averageGetTime;
    }

    public float getAveragePutTime() {
        return averagePutTime;
    }

    public void setAveragePutTime(float averagePutTime) {
        this.averagePutTime = averagePutTime;
    }

    public float getAverageRemoveTime() {
        return averageRemoveTime;
    }

    public void setAverageRemoveTime(float averageRemoveTime) {
        this.averageRemoveTime = averageRemoveTime;
    }

    public long getCacheEvictions() {
        return cacheEvictions;
    }

    public void setCacheEvictions(long cacheEvictions) {
        this.cacheEvictions = cacheEvictions;
    }

    public long getCacheGets() {
        return cacheGets;
    }

    public void setCacheGets(long cacheGets) {
        this.cacheGets = cacheGets;
    }

    public float getCacheHitPercentage() {
        return cacheHitPercentage;
    }

    public void setCacheHitPercentage(float cacheHitPercentage) {
        this.cacheHitPercentage = cacheHitPercentage;
    }

    public long getCacheHits() {
        return cacheHits;
    }

    public void setCacheHits(long cacheHits) {
        this.cacheHits = cacheHits;
    }

    public long getCacheMisses() {
        return cacheMisses;
    }

    public void setCacheMisses(long cacheMisses) {
        this.cacheMisses = cacheMisses;
    }

    public float getCacheMissPercentage() {
        return cacheMissPercentage;
    }

    public void setCacheMissPercentage(float cacheMissPercentage) {
        this.cacheMissPercentage = cacheMissPercentage;
    }

    public long getCachePuts() {
        return cachePuts;
    }

    public void setCachePuts(long cachePuts) {
        this.cachePuts = cachePuts;
    }

    public long getCacheRemovals() {
        return cacheRemovals;
    }

    public void setCacheRemovals(long cacheRemovals) {
        this.cacheRemovals = cacheRemovals;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CacheStastics{");
        sb.append("averageGetTime=").append(averageGetTime);
        sb.append(", averagePutTime=").append(averagePutTime);
        sb.append(", averageRemoveTime=").append(averageRemoveTime);
        sb.append(", cacheEvictions=").append(cacheEvictions);
        sb.append(", cacheGets=").append(cacheGets);
        sb.append(", cacheHitPercentage=").append(cacheHitPercentage);
        sb.append(", cacheHits=").append(cacheHits);
        sb.append(", cacheMisses=").append(cacheMisses);
        sb.append(", cacheMissPercentage=").append(cacheMissPercentage);
        sb.append(", cachePuts=").append(cachePuts);
        sb.append(", cacheRemovals=").append(cacheRemovals);
        sb.append('}');
        return sb.toString();
    }
}
