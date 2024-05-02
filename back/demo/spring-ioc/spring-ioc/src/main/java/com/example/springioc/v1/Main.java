package com.example.springioc.v1;

/**
 * 用传统方式来创建互相依赖的对象
 * 高耦合，最底层的类，Tire要是加几个属性，那么就会改很多地方
 */
public class Main {
    public static void main(String[] args) {
        Car car = new Car(12);
        car.run();
        Car car1 = new Car(24);
        car.run();
    }
}
