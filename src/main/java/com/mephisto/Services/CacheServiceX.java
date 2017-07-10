package com.mephisto.Services;

import org.springframework.stereotype.Service;

/**
 * Created by world on 2017/6/19.
 */
@Service
public class CacheServiceX {


    private  ICache iCache;

    public CacheServiceX() {
    }

    public CacheServiceX(ICache iCache) {
        this.iCache = iCache;
    }


    public ICache getiCache() {
        return iCache;
    }

    public void setiCache(ICache iCache) {
        this.iCache = iCache;
    }

    public String getCache(String key){
        return iCache.Get(key);
    }
}
