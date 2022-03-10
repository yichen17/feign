package com.yichen.test.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2022/3/10 13:47
 * @describe 相应结果在 springboot convert 转换测试  即原来返回结果为Long，Springboot通过convert转为String
 */
@Data
@Builder
public class DataTransform {

    private String name;
    private Long id;

}
