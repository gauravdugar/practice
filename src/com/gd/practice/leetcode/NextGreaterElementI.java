package com.gd.practice.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 496. Next Greater Element I (DONE)
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all
 * the next greater numbers for nums1's elements in the corresponding places of nums2. The Next Greater Number of a
 * number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
 * https://leetcode.com/problems/next-greater-element-i/
 */
public class NextGreaterElementI {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};

        int[] result = nextGreaterElement(nums1, nums2);

        System.out.println("nums1: " + Arrays.toString(nums1));
        System.out.println("nums2: " + Arrays.toString(nums2));
        System.out.println("Result: " + Arrays.toString(result));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = -1;
            for (int j = map.get(nums1[i]); j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    result[i] = nums2[j];
                    break;
                }
            }
        }
        return result;
    }
}
