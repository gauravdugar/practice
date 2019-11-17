package com.gd.practice.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/network-delay-time/
 *
 * There are N network nodes, labelled 1 to N.
 * Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the
 * target node, and w is the time it takes for a signal to travel from source to target. Now, we send a signal from a
 * certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.
 */
public class NetworkDelayTime {

    public static void main(String args[]) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;

        System.out.println();
        System.out.println("times: " + Arrays.deepToString(times));
        System.out.println("N: " + n);
        System.out.println("K: " + k);
        System.out.println();

        int result = Solution.networkDelayTime(times, n, k);

        System.out.println("result: " + result);
    }
}

class Solution {
    public static int networkDelayTime(int[][] times, int N, int K) {
        int result = -1;
        return result;
    }
}
