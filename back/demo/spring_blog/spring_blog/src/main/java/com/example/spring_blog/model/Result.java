package com.example.spring_blog.model;

import com.example.spring_blog.enums.ResultStatus;
import lombok.Data;

@Data
public class Result {
// 业务码 可以用枚举 -1 失败 -2 未登录 200 成功
    private ResultStatus code;
//    报错信息
    private String errMsg;
//    返回数据 还可以用泛型
    private Object data;

}
