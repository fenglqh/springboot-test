package com.example.springioc.v1;

public class Framework {
    private Bottom bottom;
    public Framework(int size) {
        bottom = new Bottom(size);
        System.out.println("init bottom");
    }
    public void run() {
        System.out.println("Framework run");
    }
}
