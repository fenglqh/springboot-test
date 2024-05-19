package com.example.springdemo3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[] n = {5,2,6,1};
//        System.out.println(countSmaller(n));
        long a = 2147483647;
        long b = (long) 2147483647 *2;
        System.out.println(a);
        System.out.println(b);
        int tp = (2147483647%1000000007);
        System.out.println(tp);
        System.out.println(2147483647L - (2147483647L * 2) > 0 ? true : false );
    }
    static int[] tmp;// 辅助数组，帮助排序
    static int[] itmp;
    static int[] index; // 记住对应位置的原始下标
    static int[] counts;
    public static List<Integer> countSmaller(int[] nums) {
        tmp = new int[nums.length];
        itmp = new int[nums.length];
        index = new int[nums.length];
        counts = new int[nums.length];
        for (int i = 0; i < nums.length; i++) index[i] = i;
        mergeSort(nums, 0, nums.length - 1);
        List<Integer> list = new ArrayList<>();
        for (int x : counts) list.add(x);
        return list;
    }

    public static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        // 左边找 排序  右边找排序
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid+1, right);
        // 找中间
        int cur1 = left, cur2 = mid + 1;
        while(cur1 <= mid && cur2 <= right) {
            if (nums[cur1] > nums[cur2]) {
                int t = index[cur1];
                counts[t] += right - cur2 + 1;
                cur1++;
            }
            else cur2++;
        }

        // 排序
        cur1 = left;
        cur2 = mid + 1;
        int i = left;
        while(cur1 <= mid && cur2 <= right) {
            if (nums[cur1] > nums[cur2]) {
                tmp[i] = nums[cur1];
                itmp[i] = index[cur1];
                i++;
                cur1++;
            } else {
                tmp[i] = nums[cur2];
                itmp[i] = index[cur2];
                cur2++;
                i++;
            }
        }

        while(cur1 <= mid) {
            tmp[i] = nums[cur1];
            itmp[i] = index[cur1];
            i++;
            cur1++;
        }
        while(cur2 <= right) {
            tmp[i] = nums[cur2];
            itmp[i] = index[cur2];
            i++;
            cur2++;
        }

        for (int j = left; j <= right; j++) {
            nums[j] = tmp[j];
            index[j] = itmp[j];
        }

    }






    public static void main1(String[] args) {
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
