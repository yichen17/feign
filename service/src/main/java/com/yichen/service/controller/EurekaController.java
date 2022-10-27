package com.yichen.service.controller;

import com.alibaba.fastjson.JSON;
import com.yichen.service.model.DataTransform;
import com.yichen.service.service.feign.EurekaFeign;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/formTest")
    public String formTest(@RequestParam String proId){
        return eurekaFeign.formTest(proId);
    }

    @PostMapping("/json")
    public String formTest(@RequestBody DataTransform dataTransform){
        return eurekaFeign.json(dataTransform);
    }

}
