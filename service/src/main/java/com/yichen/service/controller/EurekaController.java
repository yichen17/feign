package com.yichen.service.controller;

import com.yichen.service.service.feign.EurekaFeign;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2022/1/20 11:42
 * @describe
 */
@RequestMapping("/eureka")
@RestController
public class EurekaController {

    @Resource
    private EurekaFeign eurekaFeign;

    @RequestMapping("/get")
    public String eureka(){
        return eurekaFeign.eureka();
    }

}
