package com.mephisto.Exceptions;

/**
 * Created by world on 2017/7/10.
 */
public class MyException extends Exception{
    public String errNo;

    public String getErrNo() {
        return errNo;
    }

    public void setErrNo(String errNo) {
        this.errNo = errNo;
    }

    public MyException(String msg, String errNo)
    {
        super(msg);
        this.errNo = errNo;
    }

    public MyException(String msg)
    {
        super(msg);
    }
}
