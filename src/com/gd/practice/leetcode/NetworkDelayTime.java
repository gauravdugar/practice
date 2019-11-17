package com.gd.practice.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/network-delay-time/
 *
 * There are N network nodes, labelled 1 to N.
 * Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the
 * target node, and w is the time it takes for a signal to travel from source to target. Now, we send a signal from a
 * certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.
 */
public class NetworkDelayTime {

    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;

        System.out.println();
        System.out.println("times: " + Arrays.deepToString(times));
        System.out.println("N: " + n);
        System.out.println("K: " + k);
        System.out.println();

        Solution solution = new Solution();
        int result = solution.networkDelayTime(times, n, k);

        System.out.println("result: " + result);
    }
}

class Solution {

    public int networkDelayTime(int[][] times, int N, int K) {
        Set<Node> nodesVisited = new HashSet<>();
        Node[] nodeArr = new Node[N];

        // Creating array of N nodes.
        for (int i = 0; i < N; i++) {
            nodeArr[i] = new Node();
        }

        // Updating map of each node to include child nodes, and their distance.
        for (int[] time : times) {
            Node n = nodeArr[time[0]-1];
            n.map.put(time[1]-1, time[2]);
        }

        // maxDistance travelled via available path.
        int maxDistance = parseNode(nodeArr[K-1], nodeArr, nodesVisited);

        // return maxDistance if all nodes traversed, otherwise -1.
        return nodesVisited.size() != N ? -1 : maxDistance;
    }

    private int parseNode(Node n, Node[] nodeArr, Set<Node> nodesVisited) {
        Set<Integer> childNodes = n.map.keySet();
        Iterator<Integer> ite = childNodes.iterator();

        nodesVisited.add(n);
        int maxDistance = 0;

        while(ite.hasNext()) {
            Integer nextChildNode = ite.next();
            maxDistance =
                    Math.max(
                            maxDistance,
                            parseNode(nodeArr[nextChildNode], nodeArr, nodesVisited) + n.map.get(nextChildNode));
        }

        return maxDistance;
    }

    class Node {
        HashMap<Integer, Integer> map;

        Node() {
            map = new HashMap<>();
        }
    }
}
