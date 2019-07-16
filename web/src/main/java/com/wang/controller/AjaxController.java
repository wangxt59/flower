package com.wang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/ajax")
public class AjaxController {
    @RequestMapping("action1")
    public Map<String, Object>  action1() {
        Map<String, Object> retureMap = new HashMap<>();
        retureMap.put("data", "data");
        retureMap.put("code", "1");
        return retureMap;
    }
    @RequestMapping("ajaxtext")
    @ResponseBody
    public Map<String, Object>  alaxTEXT(  String uname) {
//    public String  alaxTEXT(  String uname) {
        Map<String, Object> retureMap = new HashMap<>();
        System.out.println(uname.toString());
        retureMap.put("text", uname);
        return retureMap;
//        return uname;
    }


    @RequestMapping("ajaxJson")
    @ResponseBody
    public Map<String, Object>  ajaxJson( @RequestBody Map<String, Object> uname) {
        Map<String, Object> retureMap = new HashMap<>();
        System.out.println(uname.toString());
        retureMap.put("text", uname);
        return retureMap;
    }
    @RequestMapping("ajaxSerialize")
    @ResponseBody
    public Map<String, Object>  ajaxSerialize(Map<String, Object> uname) {
        Map<String, Object> retureMap = new HashMap<>();
        System.out.println(uname.toString());
        retureMap.put("text", uname);
        return retureMap;
    }
}
