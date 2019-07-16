package com.wang.controller;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/json")
public class JsonController {

    @RequestMapping(value = "/getjson.do")
    @ResponseBody
    public Map request( String map) {
        Map returnMap=new HashMap();
        returnMap.put("data",null);
        returnMap.put("map",map);
//        System.out.println(map.toString());
//        String url=map.get("url").toString();
        return returnMap;
    }
}
