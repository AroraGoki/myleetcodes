package org.zgy.leetcodes;


import java.util.Collections;

// https://leetcode.cn/problems/median-of-two-sorted-arrays/description/?company_slug=xiaohongshu
public class Solution33 {

    public static void main(String[] args) {
        int[] test1 = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(test1, 0));
    }

    public static int search(int[] nums, int target) {
        int total = nums.length;
        if (total == 0) {
            return -1;
        }
        int from = 0, to = total-1;
        int minValue = nums[0];
        int minIdx = 0;
        for (int i = 1; i < total; i++) {
            if (nums[i] < minValue) {
                minIdx = i;
                minValue = nums[i];
            }
        }
        while(true) {
            int mid = (from + to)/2;
            int actualMid = l2p(mid, total, minIdx);
            int midValue = nums[actualMid];
            if (target == midValue) {
                return actualMid;
            } else if (target > midValue) {
                if (to == mid) {
                    return -1;
                }
                from = mid + 1;
            } else {
                if (from == mid) {
                    return -1;
                }
                to = mid - 1;
            }
        }
    }

    private static int l2p(int logicIdx, int total, int realLeft) {
        return (logicIdx + realLeft) % total;
    }
}
