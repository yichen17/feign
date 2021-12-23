package com.yichen.test.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Map;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/12/17 8:59
 * @describe  feign 测试 controller
 */
@RequestMapping("/feign")
@Controller
public class FeiginTestController {

    private static Logger logger= LoggerFactory.getLogger(FeiginTestController.class);

    /**
     * 直接通过入参 调用
     */
    @RequestMapping("/testUri")
    @ResponseBody
    public String testUri(String name){
        logger.info("testUri => name => {}",name);
        return "testURI "+name;
    }

    /**
     * 通过 @RequestParam 调用
     */
    @RequestMapping("/testUri1")
    @ResponseBody
    public String testUri1(@RequestParam("name") String name){
        logger.info("testUri1 => name => {}",name);
        return "testURI1 "+name;
    }

    /**
     * 通过解析 HttpServletRequest 常规
     */
    @RequestMapping("/testUri2")
    @ResponseBody
    public String testUri2(HttpServletRequest request)throws Exception{
        JSONObject jsonParam =  getJSONParam(request);
        String name=jsonParam==null?null:String.valueOf(jsonParam.get("name"));
        logger.info("testUri2 => name => {}",name);
        return "testURI2  "+name;
    }

    /**
     * 通过解析 HttpServletRequest    @RequestParam
     */
    @RequestMapping("/testUri3")
    @ResponseBody
    public String testUri3(HttpServletRequest request)throws Exception{
        JSONObject jsonParam = getJSONParam(request);
        String name=jsonParam==null?null:String.valueOf(jsonParam.get("name"));
        logger.info("testUri3 => name => {}",name);
        return "testURI3  "+name;
    }

    /**
     * 通过解析 HttpServletRequest    @RequestParam   解析 map
     */
    @RequestMapping("/testUri4")
    @ResponseBody
    public String testUri4(HttpServletRequest request)throws Exception{
        JSONObject jsonParam = getJSONParam(request);
        String name=jsonParam==null?null:String.valueOf(jsonParam.get("name"));
        logger.info("testUri4 => name => {}",name);
        return "testURI4  "+name;
    }

    /**
     * 通过解析 HttpServletRequest    @RequestParam   解析 map
     */
    @RequestMapping("/testUri5")
    @ResponseBody
    public String testUri5(HttpServletRequest request)throws Exception{
        JSONObject jsonParam = getJSONParam(request);
        String name=jsonParam==null?null:String.valueOf(jsonParam.get("name"));
        logger.info("testUri5 => name => {}",name);
        return "testURI5  "+name;
    }

    /**
     * @RequestBody 接收
     */
    @RequestMapping("/testUri6")
    @ResponseBody
    public String testUri6(@RequestBody Map<String, Object> params)throws Exception{
        String name=String.valueOf(params.get("name"));
        logger.info("testUri6 => name => {}",name);
        return "testURI6  "+name;
    }

    @PostMapping(value = "/sendByForm",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    String sendByForm(@RequestHeader Map<String,Object>header,@RequestParam  Map<String,Object> params){
        return "form请求结果\n header => "+JSON.toJSONString(header)+"\n params => "+JSON.toJSONString(params);
    }

    /**
     * 获取 入参
     * @param request 请求
     * @return 入参结果集
     */
    public static JSONObject getJSONParam(HttpServletRequest request) {
        JSONObject jsonParam = null;
        try {
            // 获取输入流
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));

            // 写入数据到Stringbuilder
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = streamReader.readLine()) != null) {
                sb.append(line);
            }
            jsonParam = JSONObject.parseObject(sb.toString());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.info("getJsonParam => {}", JSON.toJSONString(jsonParam));
        return jsonParam;
    }

}
