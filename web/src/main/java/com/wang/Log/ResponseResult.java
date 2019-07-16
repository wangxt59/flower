package com.wang.Log;

public class ResponseResult {


    public int code;
    public Object desc;

    public ResponseResult(int code, Object desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getDesc() {
        return desc;
    }

    public void setDesc(Object desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "code=" + code +
                ", desc=" + desc +
                '}';
    }
}
