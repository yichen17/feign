package com.yichen.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2022/1/20 11:40
 * @describe
 */
@RestController
@RequestMapping("/eureka")
public class EurekaController {

    @RequestMapping("/get")
    public String eureka(){
        return "get request by eureka";
    }

}
