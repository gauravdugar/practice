package com.gd.practice.leetcode.util;

public class BinaryTreeUtil {
    public static TreeNode createExampleTree1() {
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

    public static TreeNode createExampleTree2() {
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

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) {
            val = x;
        }

        public void printTree() {
            // This prints the tree level by level, and prints null for the null branch of all non-leaf node.
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
}
