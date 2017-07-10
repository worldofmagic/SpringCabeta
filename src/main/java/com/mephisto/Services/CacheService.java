package com.mephisto.Services;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

/**
 * Created by world on 2017/6/14.
 */
@Service
@ConfigurationProperties(prefix ="cache" )
public class CacheService {

    public String getCache_type() {
        return cache_type;
    }

    public void setCache_type(String cache_type) {
        this.cache_type = cache_type;
    }

    public int getCache_expire() {
        return cache_expire;
    }

    public void setCache_expire(int cache_expire) {
        this.cache_expire = cache_expire;
    }

    private String[] cached_servers;

    public String[] getCached_servers() {
        return cached_servers;
    }

    public void setCached_servers(String[] cached_servers) {
        this.cached_servers = cached_servers;
    }

    private String cache_type;
    private int cache_expire;
    public String getCache(String key)
    {
        for(String s : this.cached_servers)
        {
            System.out.println(s);
        }
        return "get cache type of "+this.cache_type+", will expire in "
                +String.valueOf(this.cache_expire)+" second,";
    }
}
