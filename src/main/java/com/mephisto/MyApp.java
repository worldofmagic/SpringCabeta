package com.mephisto;

/**
 * Created by world on 2017/6/14.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by world on 2017/6/7.
 */
@EnableAutoConfiguration
@ComponentScan()
public class MyApp {
    public static void main(String[] args)
    {

        SpringApplication.run(MyApp.class,args);
    }
}