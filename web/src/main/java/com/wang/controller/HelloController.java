package com.wang.controller;

//import com.wang.redis.RedisUtil;

import com.wang.entity.MWorker;
import com.wang.entity.People;
import com.wang.redis.MyRedis;
import com.wang.redis.RedisProperties;
import com.wang.redis.RedisUtil;
import com.wang.service.MWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/action")
public class HelloController {

    //    @Value("${spring.redis.host}")
//    public  String host;
    @Autowired
    public RedisProperties redisProperties;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private MyRedis myRedis;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private People people;
    @Autowired
    private MWorkerService mWorkerService;

    //       @Autowired
//    public RedisConnectionFactory factory;
    @RequestMapping(value = "/webSocket.do")
    public String webSocket() {
        System.out.println("webSocket!!!!");
        return "webSocket";
    }
    @GetMapping(value = "/aop.do", produces = "text/plain;charset=UTF-8")
    @ResponseBody()
    public String aop() {
        return "controller方法";
    }


    @RequestMapping("/workers.do")
    @ResponseBody
    public List<MWorker> workers() {
        List<MWorker> mWorkers = mWorkerService.getAllWorker(1, 1, new HashMap());
        return mWorkers;
    }

    @RequestMapping("/worker.do")
    @ResponseBody
    public String worker() {
        MWorker mWorker = mWorkerService.getworker("23432");
        System.out.println(mWorker.toString());
        System.out.println("kkjk");
        return mWorker.toString();
    }

    @RequestMapping("/redis.do")
    @ResponseBody
    public String redis() {
        redisUtil.set("aa", "sadsdasd");
//        return redisUtil.get("aa").toString();
        System.out.println("kkjksadzasa");
        return people.toString();
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        String aa = redisProperties.getHost();
        redisTemplate.opsForValue().set("abc", "1234lklksslk");
//        RedisUtil redisUtil=new RedisUtil();
//        redisUtil.set("abcde","123");
//        Object aa=redisUtil.get("abcde");

        return aa.toString();
    }

}
