package com.example.spring_blog.config;

import com.example.spring_blog.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@Slf4j
@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(Exception.class)
    public Result handle(Exception e) {
        log.error("出现异常,e :" + e.getMessage());
        return Result.fail("出现内部错误，请联系作者，QQ：1691141895");
    }
    @ExceptionHandler(NoResourceFoundException.class)
    public Result handle(NoResourceFoundException e) {
        log.error("文件不存在：{}" , e.getResourcePath());
        return Result.fail("文件路径不存在");
    }
}
