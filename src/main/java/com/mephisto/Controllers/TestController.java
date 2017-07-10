package com.mephisto.Controllers;


import com.mephisto.Util.DbHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by world on 2017/7/10.
 */
@RestController
public class TestController {
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test()
    {
        return new DbHelper().update_users_coin();
    }
}
