package com.example.springdemo3;

public class Test {
    public static void main(String[] args) {
        int[] nn = {1,2,3,4,5,6,7,0};
        System.out.println(InversePairs(nn));
    }
    static int[] n;
    public static int InversePairs (int[] nums) {
        n = new int[nums.length];
        int ret = part(nums, 0, nums.length-1);
        return ret;
    }

    private static int part(int[] nums, int left , int right) {
        if (left >= right) return 0;
        int ret = 0;
        // 1. 选择一个中间点，将数组划分为两部分
        int mid = (right + left) / 2;
        // [left,mid] [mid+1, right]
        // 2. z左半部分+排序+右半部分+排序
        ret += part(nums, left, mid);
        ret += part(nums, mid+1, right);


        int c1 = 0, c2 = left, c3 = mid+1;

        while(c2 <= mid && c3 <= right) {
            if (nums[c2] <= nums[c3]) {
                n[c1++] = nums[c2];
                c2++;
            }
            else {
                ret += mid - c2 + 1;
                n[c1++] = nums[c3];
                c3++;
            }
        }
        // 排序

        // int c1 = 0, c2 = left, c3 = mid+1;
        // while(c2 <= mid && c3 <= right) {
        //     if (nums[c2] <= nums[c3]) n[c1++] = nums[c2++];
        //     else n[c1++] = nums[c3++];
        // }
        while(c2 <= mid) n[c1++] = nums[c2++];
        while(c3 <= right) n[c1++] = nums[c3++];
        for (int i = left; i <= right; i++) {
            nums[i] = n[i - left];
        }

        return ret;
    }
}
