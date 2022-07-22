package com.yichen.service.controller;

import com.alibaba.fastjson.JSONObject;
import com.yichen.service.service.feign.FeignTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/12/17 8:56
 * @describe feign 相关测试
 */
@RestController
@RequestMapping("/feign")
public class FeignTestController {

    private static Logger logger= LoggerFactory.getLogger(FeignTestController.class);

    @Autowired
    private FeignTest feignTest;

    /**
     * 直接通过入参 调用
     */
    @RequestMapping("/testUri")
    public String testUri(String name)throws Exception{
        logger.info("testUri => name => {}",name);
        return feignTest.testURI(new URI("http://localhost:8088/feign/testUri"),name);
    }

    /**
     * 通过 @RequestParam 调用
     */
    @RequestMapping("/testUri1")
    public String testUri1(@RequestParam("name")  String name)throws Exception{
        logger.info("testUri1 => name => {}",name);
        return feignTest.testURI1(new URI("http://localhost:8088/feign/testUri1"),name);
    }

    @RequestMapping("/testUri2")
    public String testUri2(String name)throws Exception{
        logger.info("testUri2 => name => {}",name);
        return feignTest.testURI2(new URI("http://localhost:8088/feign/testUri2"),name);
    }

    @RequestMapping("/testUri3")
    public String testUri3(@RequestParam("name")  String name)throws Exception{
        logger.info("testUri3 => name => {}",name);
        return feignTest.testURI3(new URI("http://localhost:8088/feign/testUri3"),name);
    }

    @RequestMapping("/testUri4")
    public String testUri4(String name)throws Exception{
        logger.info("testUri4 => name => {}",name);
        Map<String,Object> params=new HashMap<>();
        params.put("name",name);
        params.put("age",18);
        params.put("sex","boy");
        return feignTest.testURI4(new URI("http://localhost:8088/feign/testUri4"),params);
    }

    @RequestMapping("/testUri5")
    public String testUri5(@RequestParam("name")  String name)throws Exception{
        logger.info("testUri5 => name => {}",name);
        Map<String,Object> params=new HashMap<>();
        params.put("name",name);
        params.put("age",18);
        params.put("sex","girl");
        return feignTest.testURI5(new URI("http://localhost:8088/feign/testUri5"),params);
    }

    @RequestMapping("/testUri6")
    public String testUri6(@RequestParam("name")  String name)throws Exception{
        logger.info("testUri6 => name => {}",name);
        Map<String,Object> params=new HashMap<>();
        params.put("name",name);
        params.put("age",20);
        params.put("sex","girl");
        return feignTest.testURI6(new URI("http://localhost:8088/feign/testUri6"),params);
    }

    @GetMapping("/sendByForm")
    public String sendByForm(@RequestParam("name")String name) throws URISyntaxException {
        System.out.println("name => "+name);
        Map<String,Object> params=new HashMap<>();
        params.put("age",20);
        params.put("sex","girl");
        Map<String,Object> header=new HashMap<>();
        header.put("token","reqre13423423");
        header.put("customerId","1000007421");
        return feignTest.sendByForm(new URI("http://localhost:8088/feign/sendByForm"),header,params);
    }

    @GetMapping("/testPutHeader")
    public String testPutHeader() throws URISyntaxException{
        return feignTest.testPutHeader(new URI("http://localhost:8088/feign/testPutHeader"));
    }


}
