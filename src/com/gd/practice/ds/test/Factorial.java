package com.gd.practice.ds.test;

public class Factorial {
    public static void main(String[] args) {
        System.out.println("Factorial recursive for 5: " + getFactorialRecursive(5));
        System.out.println("Factorial iterative for 5: " + getFactorialIterative(5));
    }

    public static int getFactorialIterative(int x) {
        if (x < 1) {
            return -1;
        }
        int result = 1;
        while (x > 0) {
            result *= x;
            x--;
        }
        return result;
    }

    public static int getFactorialRecursive(int x) {
        if (x < 1) {
            return -1;
        }
        return getFactorialRecursiveUtil(1, x);
    }

    private static int getFactorialRecursiveUtil(int result, int x) {
        if (x < 1) {
            return result;
        } else {
            return result * x * getFactorialRecursiveUtil(result, --x);
        }
    }
}
