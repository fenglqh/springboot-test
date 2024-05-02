package com.example.springioc.v1;

public class Bottom {
    private Tire tire;
    public Bottom(int size) {
        tire = new Tire(size);
        System.out.println("tire init...");
    }
    public void run() {
        System.out.println("Bottom run");
    }
}
