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

    public Result success(Object data) {
        Result result = new Result();
        result.setCode(ResultStatus.SUCCESS);
        result.setData(data);
        return result;
    }
    public Result fail(String errMsg) {
        Result result = new Result();
        result.setCode(ResultStatus.FAIL);
        result.setErrMsg(errMsg);
        result.setData(null);
        return result;
    }
    public Result fail() {
        Result result = new Result();
        result.setCode(ResultStatus.FAIL);
        result.setErrMsg("失败");
        return result;
    }
}
