package com.gd.practice.ds.test;

import java.util.ArrayList;

class HashMapImpl {

    private int BUCKET_COUNT = 16;

    private ArrayList<Bucket> bucketList;

    HashMapImpl() {
        bucketList = new ArrayList<>();
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

    Node firstNode;

    public Node findNode(int hash) {
        Node currentNode = firstNode;
        while (currentNode != null) {
            if (currentNode.hash == hash) {
                break;
            }
            currentNode = currentNode.nextNode;
        }
        return currentNode;
    }
}

class Node {
    String key;
    String value;
    int hash;
    Node nextNode;

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
