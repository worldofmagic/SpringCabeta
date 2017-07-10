package com.mephisto.AOP;

import com.mephisto.Exceptions.MyException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by world on 2017/7/10.
 */
@Component
@Aspect
public class UserPointcut {

    @Autowired
    HttpServletRequest httpServletRequest;

    @Pointcut("execution(* com.mephisto.Services.UserService.getUserInfo(int))")
    public void myToken(){}

    @Before("myToken()")
    public void checkToken() throws MyException
    {
        String getToken = httpServletRequest.getParameter("token");
        if(getToken == null)
        {
            throw new MyException("token not exist","10010");
        }
        if(!getToken.equals("jtthink"))
        {
            throw new MyException("token invalid","10011");
        }
    }

}
