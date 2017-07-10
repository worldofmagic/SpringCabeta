package com.mephisto.Controllers;

import com.mephisto.Entities.ErrorResult;
import com.mephisto.Exceptions.MyException;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by world on 2017/7/10.
 */
@RestController
public class MyErrController implements ErrorController{
    @RequestMapping(value = "/error")
    public ErrorResult myError(HttpServletResponse rs)
    {
        ErrorResult errorResult = new ErrorResult("0404","not found",rs.getStatus());
        return errorResult;
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
