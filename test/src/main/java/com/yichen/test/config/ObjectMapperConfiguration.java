package com.yichen.test.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2022/3/09 10:14
 * @describe springboot 对象转换
 */
@JsonComponent
public class ObjectMapperConfiguration {

    /**
     *  Long型数据转换成json格式时丢失精度问题
     *  => 可能存在问题   原先目标就想返回 Long类型，但是这边让它变成了 String
     *  => 改方法为创建前为 Long => Long ，如今变成 Long => String 的影响问题
     */
    @Bean
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        //忽略value为null 时 key的输出
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

//        序列换成json时,将所有的long变成string  因为js中得数字类型不能包含所有的java long值
        SimpleModule module = new SimpleModule();
        module.addSerializer(Long.class, ToStringSerializer.instance);
        module.addSerializer(Long.TYPE, ToStringSerializer.instance);
        objectMapper.registerModule(module);
        return objectMapper;
    }
}
