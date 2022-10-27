package com.yichen.service.service.feign;

import com.yichen.service.model.DataTransform;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2022/1/20 11:38
 * @describe 测试通过 eureka 读取数据
 */
@FeignClient(name = "feign-producer")
public interface EurekaFeign {

    @RequestMapping("/eureka/get")
    String eureka();

    @PostMapping(value = "/eureka/formTest", consumes = MediaType.APPLICATION_JSON_VALUE)
    String formTest(@RequestParam String proId);

    @PostMapping(value = "/eureka/json" )
    String json(@RequestBody DataTransform dataTransform);



}
