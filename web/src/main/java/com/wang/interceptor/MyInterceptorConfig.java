//package com.wang.interceptor;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.StringHttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//import java.nio.charset.Charset;
//
//
///**
// *
// * @ClassName: MyInterceptor
// * @Description:springboot拦截器配置
// * @author cheng
// * @date 2017年9月19日 下午10:14:48
// */
//@Configuration//表示这是一个配置类
//@EnableWebMvc
//public class MyInterceptorConfig extends WebMvcConfigurationSupport {
//    // spring boot默认就有消息转化器，其编码格式为utf-8
//    @Bean
//    public StringHttpMessageConverter stringHttpMessageConverter() {
//        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
//        return stringHttpMessageConverter;
//    }
//    @Autowired
//    private MyInterceptor myInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // 添加拦截器并设置拦截规则
//        // /*表示路径
//        // /**表示路径及其自路径     registry.addInterceptor(myInterceptor).addPathPatterns("/**");
//    }
//
//}