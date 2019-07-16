package com.wang.Log;
//自定义异常类
public class NoPermissions extends Exception{
    private static final long serialVersionUID=1L;

    public NoPermissions(String message) {
        super(message);
    }
}
