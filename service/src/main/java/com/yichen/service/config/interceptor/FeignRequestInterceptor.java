package com.yichen.service.config.interceptor;

import com.alibaba.fastjson.JSON;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2022/7/22 9:46
 * @describe feigin 拦截器，添加请求头
 */
@Component
@Slf4j
public class FeignRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        log.info("表单数据 {}", JSON.toJSONString(template.queries()));
        // 设置请求头
        template.header("loginSource","xy");
    }
}
