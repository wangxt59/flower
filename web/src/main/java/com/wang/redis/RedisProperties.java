package com.wang.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:redis.properties")
@Component
//@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {

    @Value("${spring.redis.database}")
    public String database;
    @Value("${spring.redis.host}")
    public String host;
    @Value("${spring.redis.port}")
    public String port;
    @Value("${spring.redis.password}")
    public String  password;
    @Value("${spring.redis.jedis.pool.max-active}")
    public String timeout;

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

}
