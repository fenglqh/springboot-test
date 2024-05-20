package com.example.springdemo3.adpter;
/**
 * 适配器的代码练习
 * 适配器其实是一种思想，有关涉模式的门面模式
 * 使用者调用的是适配器，适配器里调用真正实现功能的接口
 * 适配器本质是一种补救，因为接口设置的不合理，改动很麻烦
 */
public class Log4jAdapter implements Slf4jLog{
//    适配器本质上是调用Log4j
    private Log4j log4j;
    public Log4jAdapter(Log4j log4j) {
        this.log4j = log4j;
    }
    @Override
    public void log(String msg) {
        log4j.log("我是适配器，打印的日志内容为: " + msg);
    }
}
