package com.yichen.service.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
