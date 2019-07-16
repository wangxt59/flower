package com.wang.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//exclude = DataSourceAutoConfiguration.class
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ImportResource
@Controller
@ComponentScan(basePackages ={ "com.wang"})
@MapperScan("com.wang.dao")
public class WebApplication {
//    public class WebApplication extends WebMvcConfigurationSupport {

// 若要部署到外部servlet容器,需要继承SpringBootServletInitializer并重写configure()
//public class WebApplication extends SpringBootServletInitializer {
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		// 设置启动类,用于独立tomcat运行的入口
//		return builder.sources(WebApplication.class);
//	}


	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

	/**
	 * 1、 extends WebMvcConfigurationSupport
	 * 2、重写下面方法;
	 *      setUseSuffixPatternMatch: 设置是否是后缀模式匹配，如“/user”是否匹配/user.*，默认真即匹配；
	 *      setUseTrailingSlashMatch: 设置是否自动后缀路径模式匹配，如“/user”是否匹配“/user/”，默认真即匹配；
	 */
//    @Override
//    protected void configurePathMatch(PathMatchConfigurer configurer) {
//        configurer
//                .setUseSuffixPatternMatch(true)
//                .setUseTrailingSlashMatch(true);
//    }
	//	@RequestMapping("/")
//	@ResponseBody
//	public String hello() {
//		return "index";
//	}
}
