package com.example.springioc.v2;


/**
 * 对传统方法进行一个简单解耦合，既然各个地方的参数都高度依赖Tire的属性的话
 * 那就直接传对象
 * 但是还是有缺点，需要一直new对象
 * 传统方法创建对象的控制权在每一个类里（调用方）
 * 现在是在main方法中
 */
public class Main {
    public static void main(String[] args) {
        Tire tire = new Tire(12);
        Bottom bottom = new Bottom(tire);
        Framework framework = new Framework(bottom);
        Car car = new Car(framework);
        car.run();
    }
}
