package com.mephisto.Controllers;

import com.mephisto.Entities.UserCoin;
import com.mephisto.Entities.UserInfo;
import com.mephisto.Mappers.UserMapper;
import com.mephisto.Services.CacheService;
import com.mephisto.Services.CacheServiceX;
import com.mephisto.Services.RedisCache;
import com.mephisto.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.List;
import java.util.Map;

/**
 * Created by world on 2017/6/14.
 */
@RestController
public class UserControllers {

    @Autowired
    CacheService cacheService;

    @Autowired
    CacheServiceX cacheServiceX;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @RequestMapping(value ="/user",method= RequestMethod.GET )
    public String getUser()
    {
        List list = jdbcTemplate.queryForList("SELECT * FROM news");
        for(Object obj:list)
        {
            System.out.println(((Map)obj).get("title"));
        }
        return "success";
    }


    @RequestMapping(value ="/userinfo/{uid:\\d+}",method = RequestMethod.GET)
    public UserInfo getUserInfo(@PathVariable("uid") int userId)
    {
        return userMapper.getUserById(userId);
    }

    @RequestMapping(value ="/userinfo",method = RequestMethod.GET)
    public List<UserInfo> getAllUserInfo()
    {
        return userMapper.getAllUsers();
    }

    @RequestMapping(value ="/userinfo",method = RequestMethod.POST)
    public int newUser(@RequestBody UserInfo userInfo)
    {
        userMapper.addUser(userInfo);
        return userInfo.getUser_id();
    }

    @RequestMapping(value = "/user/coin",method = RequestMethod.PUT)
    public String coin(@RequestBody List<UserCoin> userCoinList)
    {
        UserCoin fromUser = userCoinList.get(0);
        UserCoin toUser = userCoinList.get(1);
        if(userService.transferCoin(fromUser.getUser_id(),toUser.getUser_id(),fromUser.getCoin()))
        {
            return "success";
        }
        else
        {
            return "failed";
        }
    }
}