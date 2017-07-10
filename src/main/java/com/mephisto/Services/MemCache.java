package com.mephisto.Services;

/**
 * Created by world on 2017/6/19.
 */
public class MemCache implements ICache {
    @Override
    public String Get(String key) {
        return "get MemCache " + key;
    }
}
