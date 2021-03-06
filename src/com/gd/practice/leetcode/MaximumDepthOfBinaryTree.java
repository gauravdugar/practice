package com.gd.practice.leetcode;

import static com.gd.practice.leetcode.util.BinaryTreeUtil.createExampleTree1;

import com.gd.practice.leetcode.util.BinaryTreeUtil.TreeNode;

/**
 * 104. Maximum Depth of Binary Tree (DONE)
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        System.out.println("\n\nmaxDepth of binary tree: " + maxDepth(createExampleTree1()));
    }

    public static int maxDepth(TreeNode node) {
        int maxDepth = 0;
        if (node != null) {
            return (Math.max(maxDepth(node.left), maxDepth(node.right))) + 1;
        }
        return maxDepth;
    }
}
