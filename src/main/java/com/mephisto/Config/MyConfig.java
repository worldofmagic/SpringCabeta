package com.mephisto.Config;

import com.mephisto.Services.CacheServiceX;
import com.mephisto.Services.RedisCache;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by world on 2017/6/19.
 */
@Configuration
public class MyConfig {
    @Value("${cache.cache_expire}")
    private int timeout;
    @Bean
    public RedisCache redisCache()
    {
        RedisCache r = new RedisCache("127.0.0.2","6638");
        r.setTimeout(this.timeout);
        return r;
    }

    @Bean
    public CacheServiceX cacheServiceX(){
        CacheServiceX c = new CacheServiceX(this.redisCache());
        return c;
    }

    @Bean
    public DataSource dataSource(){
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/cabeta?characterEncoding=UTF-8");
        dataSource.setUsername("mephistoyzh");
        dataSource.setPassword("9EANRo4Df3ElGfSr");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager()
    {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource());
        return dataSourceTransactionManager;
    }
}
