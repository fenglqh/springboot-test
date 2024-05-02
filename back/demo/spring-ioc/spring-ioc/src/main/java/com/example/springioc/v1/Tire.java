package com.example.springioc.v1;

public class Tire {
    /**
     * 传统方式最麻烦是是改需求，比如这个size不能写死那么，就要从里改到外
     */
//    private int size = 15;
//    public Tire() {
//        System.out.println("This is a tire " + size);
//    }
     private int size;
     public Tire(int size) {
         System.out.println("This is a tire " + size);
    }
}
