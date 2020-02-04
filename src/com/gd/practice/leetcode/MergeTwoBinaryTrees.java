package com.gd.practice.leetcode;

import static com.gd.practice.leetcode.util.BinaryTreeUtil.createExampleTree1;
import static com.gd.practice.leetcode.util.BinaryTreeUtil.createExampleTree2;

import com.gd.practice.leetcode.util.BinaryTreeUtil.TreeNode;

/**
 * 617. Merge Two Binary Trees (DONE)
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are
 * overlapped while the others are not.
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up
 * as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 * https://leetcode.com/problems/merge-two-binary-trees/
 */
public class MergeTwoBinaryTrees {
    public static void main(String[] args) {
        TreeNode mergedTree = mergeTrees(createExampleTree1(), createExampleTree2());
        if (mergedTree == null) {
            System.out.println("Merged tree is EMPTY.");
        } else {
            mergedTree.printTree();
        }
    }

    private static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;

        TreeNode result = new TreeNode(t1.val + t2.val);
        result.left = mergeTrees(t1.left, t2.left);
        result.right = mergeTrees(t1.right, t2.right);
        return result;
    }
}


