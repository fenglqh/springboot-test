package com.example.springdemo3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
// 注解的声明 不具有运行的逻辑
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface InitMethed {
}
