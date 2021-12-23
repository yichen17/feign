package com.yichen.service.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.*;
import java.net.URI;
import java.util.Map;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/12/17 8:57
 * @describe feigin 相关测试
 */
@FeignClient(name = "feignTest",url = "dynamicUrl")
public interface FeignTest {
    /**
     * 动态路由 通过  URI指定
     */
    @RequestMapping
    String testURI(URI url, String name);
    /**
     * 动态路由 通过  URI指定 使用  @RequestParam
     */
    @RequestMapping
    String testURI1(URI url,@RequestParam("name") String name);

    /**
     * 通过  HttpServletRequest 解析数据
     */
    @RequestMapping
    String testURI2(URI url, String name);

    /**
     * 通过 HttpServletRequest 解析数据
     */
    @RequestMapping
    String testURI3(URI url,@RequestParam("name") String name);

    /**
     * 通过 HttpServletRequest 解析数据
     */
    @RequestMapping
    String testURI4(URI url,Map<String, Object> params);

    /**
     * 通过 HttpServletRequest 解析数据
     */
    @RequestMapping
    String testURI5(URI url,@RequestParam Map<String, Object> params);

    /**
     * 通过 @RequestBody 接收
     */
    @RequestMapping
    String testURI6(URI url,Map<String, Object> params);

    /**
     * 通过表单提交数据
     */
    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    String sendByForm(URI url,@RequestHeader Map<String,Object>header, @RequestParam Map<String,Object> params);


}
