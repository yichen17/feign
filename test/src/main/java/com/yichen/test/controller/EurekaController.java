package com.yichen.test.controller;

import com.alibaba.fastjson.JSON;
import com.yichen.test.model.DataTransform;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2022/1/20 11:40
 * @describe
 */
@RestController
@RequestMapping("/eureka")
@Slf4j
public class EurekaController {

    @RequestMapping("/get")
    public String eureka() throws Exception{
        Thread.sleep(1500);
        return "get request by eureka";
    }

    @PostMapping("/formTest")
    public String formTest(@RequestParam String proId){
        log.info(proId);
        return proId;
    }

    @PostMapping(value = "/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String formTest(@RequestBody DataTransform dataTransform){
        return JSON.toJSONString(dataTransform);
    }

}
