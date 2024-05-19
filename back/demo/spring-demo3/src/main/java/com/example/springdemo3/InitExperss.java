package com.example.springdemo3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InitExperss {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class clazz = Class.forName("com.example.springdemo3.InitDemo");
        Method[] methods = clazz.getMethods();
        if (methods != null && methods.length > 0) {
            for (Method method : methods) {
                boolean annotationPresent = method.isAnnotationPresent(InitMethed.class);
                System.out.println(method.getName() + " " + annotationPresent);
                if (annotationPresent) {
                    method.invoke(clazz.getConstructor(null).newInstance(null),null);
                }
            }
        }
    }
}
