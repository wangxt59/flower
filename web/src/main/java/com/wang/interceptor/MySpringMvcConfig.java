//package com.wang.interceptor;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.StringHttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//import java.nio.charset.Charset;
//import java.util.List;
//
//@Configuration
//@EnableWebMvc
//public class MySpringMvcConfig extends WebMvcConfigurationSupport {
////public class MySpringMvcConfig extends WebMvcConfigurerAdapter {//过时
//
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
//        converters.add(stringHttpMessageConverter);
//    }
//}