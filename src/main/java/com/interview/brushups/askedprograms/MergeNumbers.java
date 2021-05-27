package com.interview.brushups.askedprograms;

import java.util.Arrays;

/**
 * The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has a size equal to m + n such that it has enough space to hold additional elements from nums2.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Example 2:
 *
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 */
public class MergeNumbers {

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        if (nums2.length == 0) {
            for (int n : nums1) {
                System.out.print(n + " ");
            }
            System.exit(0);
        }

        int numStartIndex = (nums1.length - nums2.length);

        int nums2Index = 0;
        for (int i = numStartIndex; i < nums1.length; i++) {
            nums1[i] = nums2[nums2Index];
            nums2Index++;
        }
        Arrays.sort(nums1);

        for (int n : nums1) {
            System.out.print(n + " ");
        }

    }


}
