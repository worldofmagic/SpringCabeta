package com.mephisto.Services;

/**
 * Created by world on 2017/6/19.
 */
public class RedisCache implements ICache {
    private String ip;
    private String port;
    private int timeout=60;

    public RedisCache(String ip, String port) {
        this.ip = ip;
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    @Override
    public String Get(String key) {
        return "get redis cache, key is "+ key+", IP and port is: "+ip+":"+port+", timeout is "+timeout;
    }
}
