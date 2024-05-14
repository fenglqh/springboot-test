package com.example.springdemo3.model;

import com.example.springdemo3.enums.ResultStatus;
import lombok.Data;

@Data
public class Result<T> {
    private ResultStatus code; // 业务码 (不等同于http的状态码) 200 - 成功 -2 失败 - 1 未登录
    private String errMsg;
    // 但是最后要返回的数据类型不固定，不同业务需要返回的类型不一样，可以用泛型或者object
    private T result;

    public static <T> Result success(T data) {// 静态方法
        Result result = new Result();
        result.setCode(ResultStatus.SUCCESS);
        result.setResult(data);
        return result;
    }

    public static <T> Result fail() {
        Result result = new Result();
        result.setCode(ResultStatus.UNLOGIN);
        result.setErrMsg("用户未登录");
        return result;
    }
}
