package com.wang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String defaultPage() {
//springboot的默认欢迎页是index.html，可以自己配置

        return "pages/login";
    }
    @RequestMapping(value = "request.do",method = RequestMethod.POST)
    public ModelAndView request(@RequestBody Map map) {
        Map returnMap=new HashMap();
        returnMap.put("data",null);
        returnMap.put("map","map");
        System.out.println(map.toString());
        String url=map.get("url").toString();
        return new ModelAndView("page/ajax",returnMap);
    }

}
