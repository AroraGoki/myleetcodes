package org.zgy.leetcodes;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.cn/problems/median-of-two-sorted-arrays/description/?company_slug=xiaohongshu
public class Solution15 {

    public static void main(String[] args) {
        int[] test1 = new int[]{-1,2,1,-4};
        System.out.println(threeSumClosest(test1, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int targetDis = Math.abs(nums[0] + nums[1] + nums[2] - target);
        int minDisValue = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);

        for(int i = 0; i < nums.length-2; i++) {
            int a = nums[i];
            int p = i + 1, q = nums.length-1;
            while(q > p) {
                int dis = a + nums[p] + nums[q] - target;
                if (Math.abs(dis) < targetDis) {
                    targetDis = Math.abs(dis);
                    minDisValue = a + nums[p] + nums[q];
                }
                if (dis > 0) {
                    q--;
                } else if (dis == 0) {
                    return a + nums[p] + nums[q];
                } else {
                    p++;
                }
            }
        }
        return minDisValue;
    }
}
