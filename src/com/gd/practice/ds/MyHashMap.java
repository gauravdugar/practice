package com.gd.practice.ds;

import java.util.ArrayList;
import java.util.LinkedList;

class HashMapImpl {

    private int BUCKET_COUNT = 16;

    HashMapImpl() {

    }

    public void put(String key, String value) {
        if (key == null) {
            throw new RuntimeException("null key is not supported.");
        }
    }

    public String get(String key) {
        return null;
    }

    public boolean contains(String key) {
        return true;
    }

    public void remove(String key) {

    }

    private void rearrange() {

    }

    private int getBucketIndexByKey(String key) {
        int hashCode = key.hashCode();
        return hashCode % BUCKET_COUNT;
    }

    public void printMap() {
        System.out.println("Bucket Count: " + BUCKET_COUNT);
    }
}

class Bucket {

}

class Node {
    private String key;
    private String value;
    private int hash;

    Node(String key, String value, int hash) {
        this.hash = hash;
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Key: " + key + ", Value: " + value + ", Hash: " + hash;
    }
}

public class MyHashMap {
    public static void main(String args[]) {
        System.out.println("This is my HashMap implementation");
    }
}
