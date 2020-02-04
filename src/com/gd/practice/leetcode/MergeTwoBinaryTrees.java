package com.gd.practice.leetcode;

import javax.annotation.Nonnull;

/**
 * 617. Merge Two Binary Trees
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are
 * overlapped while the others are not.
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up
 * as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 * https://leetcode.com/problems/merge-two-binary-trees/
 */
public class MergeTwoBinaryTrees {
    public static void main(String[] args) {
        TreeNode firstTree = createExampleTree1();
        TreeNode secondTree = createExampleTree2();
        TreeNode mergedTree = mergeTrees(firstTree, secondTree);
        mergedTree.printTree();
    }

    @Nonnull
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            throw new RuntimeException("Both trees are null. Unable to merge.");
        }
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;

        TreeNode result = new TreeNode(1);

        return  result;
    }

    private static TreeNode createExampleTree1() {
         /*
           Tree 1
              1
             / \
            3   2
           /
          5
        */
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;

        t1.printTree();
        return t1;
    }

    private static TreeNode createExampleTree2() {
         /*
           Tree 2
              2
             / \
            1   3
             \   \
              4   7
        */
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(1);
        TreeNode t7 = new TreeNode(3);
        TreeNode t8 = new TreeNode(4);
        TreeNode t9 = new TreeNode(7);

        t5.left = t6;
        t5.right = t7;
        t6.right = t8;
        t7.right = t9;

        t5.printTree();
        return t5;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }

    void printTree() {
        System.out.print("\n" + val);
        printTreeUtil(this);
    }

    private void printTreeUtil(TreeNode node) {
        if (node == null) {
            return;
        }
        String leftVal = node.left != null ? String.valueOf(node.left.val) : "null";
        String rightVal = node.right != null ? String.valueOf(node.right.val) : "null";
        if (node.left != null || node.right != null) {
            System.out.print(", " + leftVal + ", " + rightVal);
            printTreeUtil(node.left);
            printTreeUtil(node.right);
        }
    }
}


