package org.zgy.leetcodes;

public class Solution300 {

    public static void main(String[] args) {
        int[] test = new int[]{3,5,6,2,5,4,19,5,6,7,12};
        System.out.println(lengthOfLIS2(test));
    }

    public static int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        // 注意：这里 dp[i] 表示的是 num[i] 必须被选中的情况下的 num
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    // 错误尝试
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[][] dpArray = new int[nums.length][2];
        dpArray[0][0] = nums[0];
        dpArray[0][1] = 1;

        for (int i = 1; i < nums.length; i ++) {
            dp(dpArray, nums, i);
            System.out.println(i + ": " + dpArray[i][0] + " --> " + dpArray[i][1]);
        }
        return dpArray[nums.length - 1][1];
    }

    private static void dp(int[][] dpArray, int[] nums, int cur) {
        int maxValue = 0;
        int maxNum = 0;
        int curValue = nums[cur];
        for (int i = 0; i < cur; i ++) {
            int[] dpi = dpArray[i];
            int curMaxValue = dpi[0];
            int curMaxNum = dpi[1];
            if (curValue > curMaxValue) {
                curMaxValue = curValue;
                curMaxNum ++;
            } else if (curMaxNum == 1) {
                curMaxValue = Math.min(curValue, curMaxValue);
            }

            if (i == 0) {
                maxValue = curMaxValue;
                maxNum = curMaxNum;
            } else {
                if (curMaxNum > maxNum) {
                    maxNum = curMaxNum;
                    maxValue = curMaxValue;
                } else if (curMaxNum == maxNum) {
                    maxValue = Math.min(maxValue, curMaxValue);
                }
            }
        }
        dpArray[cur][0] = maxValue;
        dpArray[cur][1] = maxNum;
    }
}
