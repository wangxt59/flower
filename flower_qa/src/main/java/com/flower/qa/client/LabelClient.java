package com.flower.qa.client;

import com.flower.common.entity.Result;
import com.flower.qa.client.impl.LabelClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(value = "flower-base",fallback = LabelClientImpl.class)
public interface LabelClient{

    @RequestMapping(value = "label/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable("id") String id);

    @RequestMapping(value = "label/test",method = RequestMethod.GET)
    public Result eurekaTest();
}
