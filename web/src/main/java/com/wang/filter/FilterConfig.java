package com.wang.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * desc : 过滤器配置
 * create_user : cheng
 * create_date : 2018/9/4 18:36
 */
@Configuration
public class FilterConfig {

    /**
     * 日志打印
     */
    private Logger log = LoggerFactory.getLogger(FilterConfig.class);

    /**
     * desc : 注册关键词处理过滤器
     * create_user : cheng
     * create_date : 2018/9/4 19:04
     */
    @Bean
    public FilterRegistrationBean registerKeywordHandleFilter() {
        FilterRegistrationBean filterBean = new FilterRegistrationBean();

        KeywordHandleFilter keywordHandleFilter = new KeywordHandleFilter();

        // 设置过滤器名称, 执行顺序, 拦截url
        String filterName = keywordHandleFilter.getClass().getSimpleName();
        int order = 3;
        List<String> urlPatterns = new ArrayList<>(1);
        urlPatterns.add("/v1/query/keyword");

        filterBean.setFilter(keywordHandleFilter);
        filterBean.setName(filterName);
//        注意:registrationBean.setOrder(1)是设置该过滤器执行的顺序。SpringBoot会根据order从小到大的顺序执行
        filterBean.setOrder(order);
        filterBean.setUrlPatterns(urlPatterns);

        log.info(String.format("注册过滤器, 过滤器name: %s, 过滤器order: %d, 过滤器过滤url: %s", filterName, order, urlPatterns));
        return filterBean;
    }



}
