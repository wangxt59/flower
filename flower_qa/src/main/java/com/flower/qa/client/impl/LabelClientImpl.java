package com.flower.qa.client.impl;

import com.flower.common.entity.Result;
import com.flower.common.entity.StatusCode;
import com.flower.qa.client.LabelClient;
import org.springframework.stereotype.Component;

@Component
public class LabelClientImpl implements LabelClient{
    @Override
    public Result findById(String id) {
        return new Result(false, StatusCode.ERROR,"熔断器启动了");
    }

    @Override
    public Result eurekaTest() {
        return new Result(false, StatusCode.ERROR,"熔断器启动了");
    }
}
