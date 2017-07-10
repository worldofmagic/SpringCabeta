package com.mephisto.Config;

import com.mephisto.Entities.ErrorResult;
import com.mephisto.Exceptions.MyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by world on 2017/7/10.
 */

@RestControllerAdvice
public class MyHandler {

    @ExceptionHandler(value = {MyException.class})
    public ErrorResult myHandler(MyException ex,HttpServletResponse rs)
    {
        ErrorResult  errorResult = new ErrorResult(ex.getErrNo(),ex.getMessage(),rs.getStatus() );
        return errorResult;
    }

}
