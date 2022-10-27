package com.yichen.service.config.interceptor;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author Qiuxinchao
 * @date 2022/10/25 17:58
 * @describe
 */
@Configuration
public class Config {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
