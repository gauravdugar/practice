package com.gd.practice.random;

import java.util.HashSet;
import java.util.Set;

public class TreeEraser {

    private Set<Node> res;

    private boolean shouldBeErased(Node n) {
        // Does something
        return false;
    }

    public Set<Node> getForestRootNodes(Node root) {
        res = new HashSet<>();

        if (root != null) {
            getForestUtil (root);
        }
        return res;
    }

    private void  getForestUtil (Node n) {
        if (shouldBeErased(n)) {
            res.remove(n);

            if (n.left != null) {
                res.add(n.left);
                getForestUtil (n.left);
            }

            if (n.right != null) {
                res.add(n.right);
                getForestUtil (n.right);
            }
        }
    }

    class Node {
        private String name;
        Node left;
        Node right;

        Node (String name, Node left, Node right) {
            this.name = name;
            this.left = left;
            this.right = right;
        }
        public String toString() {
            return this.name;
        }
    }

}
