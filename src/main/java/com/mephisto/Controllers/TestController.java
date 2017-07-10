package com.mephisto.Controllers;


import com.mephisto.Exceptions.MyException;
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
    public String test() throws Exception
    {
        throw new Exception("test exception");
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public String test2() throws Exception
    {
        throw new MyException("exception","10010");
    }



}
