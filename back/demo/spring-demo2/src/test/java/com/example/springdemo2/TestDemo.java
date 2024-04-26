package com.example.springdemo2;

import java.util.Arrays;

public class TestDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            System.out.println(i +"  "+  Integer.toBinaryString(i));
//            System.out.println(i +"  "+  Integer.toUnsignedString(i));
        }
    }
    public static void main2(String[] args) {
        int a = -1, b = -2, c = -3;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(c));
        int[] nums = {-1,0,-3,0,-2,-2};
        System.out.println((-1)^(-3));
        System.out.println(Arrays.toString(singleNumber(nums)));
    }
    public static int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int x : nums) xor = (xor ^ x);
        int lowbit = (xor & (-xor)) - 1;// 最低位为1的位置
        int m = 0, n = 0;
        for (int x : nums) {
            if ((( x >> lowbit) & 1) == 0)  {
                m = (m ^ x);
            }
            else {
                n = (n ^ x);
            }
        }
        int[] ans = {m,n};
        return ans;
    }
    public static void main1(String[] args) {
//        String a = "12\\\"3"\";
        Character c = 'a';
        Integer b = Integer.valueOf(c);
        System.out.println(b);
    }
}
