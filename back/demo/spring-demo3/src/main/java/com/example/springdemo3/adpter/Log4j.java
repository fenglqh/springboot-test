package com.example.springdemo3.adpter;

public class Log4j implements Slf4jLog{
    @Override
    public void log(String msg) {
        System.out.println("我是Log4j，打印的日志内容为: " + msg);
    }
}
