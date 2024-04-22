package org.zgy.leetcodes;


// https://leetcode.cn/problems/median-of-two-sorted-arrays/description/?company_slug=xiaohongshu
public class Solution4 {

    public static void main(String[] args) {
        int[] test1 = new int[]{1, 2};
        int[] test2 = new int[]{3, 4};
        System.out.println(findMedianSortedArrays(test1, test2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        boolean isOdd = (nums1.length + nums2.length) % 2 == 1;
        int half = (nums1.length + nums2.length) / 2;

        int q = 0, j = 0, cur = 0, next = 0;
        for (int i = 0; i < half; i++) {
            if (q < nums1.length && j < nums2.length) {
                if (nums1[q] <= nums2[j]) {
                    cur = nums1[q];
                    q++;
                } else {
                    cur = nums2[j];
                    j++;
                }
            } else if (q < nums1.length) {
                cur = nums1[q];
                q++;
            } else {
                cur = nums2[j];
                j++;
            }
        }
        if (q < nums1.length && j < nums2.length) {
            next = Math.min(nums1[q], nums2[j]);
        } else if (q < nums1.length) {
            next = nums1[q];
        } else {
            next = nums2[j];
        }
        if (isOdd) {
            return next;
        } else {
            return ((double)cur + (double)next)/2;
        }
    }
}
