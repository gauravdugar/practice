package com.gd.practice.ds;

public class BinarySearchTree {

    public TreeNode root;

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.addNode(10);
        bst.addNode(5);
        bst.addNode(15);
        bst.addNode(12);
        bst.addNode(7);
        bst.addNode(11);
        bst.addNode(5);

        System.out.println("\n" + bst.root);

        System.out.println("Search 5: " + bst.searchNode(5));
        System.out.println("Search 50: " + bst.searchNode(50));
        System.out.println("Search 10: " + bst.searchNode(10));
    }

    public void addNode(int val) {
//        addNodeIteratively(val);
        addNodeRecursively(val);
    }

    public void addNodeIteratively(int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null) {
            root = newNode;
        } else {
            TreeNode current = root;
            boolean done = false;
            while (!done){
                if (newNode.val > current.val) {
                    if (current.right == null) {
                        current.right = newNode;
                        done = true;
                    } else {
                        current = current.right;
                    }
                } else if (newNode.val < current.val) {
                    if (current.left == null) {
                        current.left = newNode;
                        done = true;
                    } else {
                        current = current.left;
                    }
                } else {
                    done = true;
                }
            }
        }
    }

    private void addNodeRecursively(int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null) {
            root = newNode;
        } else {
            addNodeRecursivelyUtil(root, newNode);
        }
    }

    private void addNodeRecursivelyUtil(TreeNode current, TreeNode newNode) {
        if (newNode.val > current.val) {
            if (current.right == null) {
                current.right = newNode;
            } else {
                addNodeRecursivelyUtil(current.right, newNode);
            }
        } else if (newNode.val < current.val) {
            if (current.left == null) {
                current.left = newNode;
            } else {
                addNodeRecursivelyUtil(current.left, newNode);
            }
        }
    }

    public TreeNode searchNode(int val) {
        TreeNode current = root;
        while (current != null) {
            if (current.val == val) {
                break;
            } else if (current.val > val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return current;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "[" + val + "-" + left + "-" + right + "]";
        }
    }
}
