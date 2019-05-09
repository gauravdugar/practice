package com.gd.practice.ds.test;

import java.util.ArrayList;

class HashMapImpl {

    private int BUCKET_COUNT = 4;

    private ArrayList<Bucket> bucketList;

    HashMapImpl() {
        bucketList = new ArrayList<>();

        int bucketIndex = 0;
        while (bucketIndex < BUCKET_COUNT) {
            bucketList.add(new Bucket(bucketIndex));
            bucketIndex++;
        }
    }

    public void put(String key, String value) {
        if (key == null) {
            throw new RuntimeException("null key is not supported.");
        }
        Node n = new Node(key, value, key.hashCode());
        Bucket b = bucketList.get(getBucketIndexByKey(key));
        b.addNode(n);
    }

    public String get(String key) {
        Bucket b = bucketList.get(getBucketIndexByKey(key));
        Node n = b.findNode(key.hashCode());
        return n == null ? null : n.value;
    }

    public boolean contains(String key) {
        Bucket b = bucketList.get(getBucketIndexByKey(key));
        return b.findNode(key.hashCode()) != null;
    }

    public void remove(String key) {
        Bucket b = bucketList.get(getBucketIndexByKey(key));
        b.removeNode(key);
    }

    private void rearrange() {

    }

    private int getBucketIndexByKey(String key) {
        int hashCode = key.hashCode();
        return hashCode % BUCKET_COUNT;
    }

    public void printMap() {
        System.out.println("Bucket Count: " + BUCKET_COUNT);

        for (Bucket b : bucketList) {
            System.out.println("Bucket " + b.bucketIndex);
            Node currentNode = b.firstNode;
            while (currentNode != null) {
                System.out.println(currentNode);
                currentNode = currentNode.nextNode;
            }
            System.out.println();
        }
    }
}

class Bucket {

    int bucketIndex;
    Node firstNode;

    Bucket(int bucketIndex) {
        this.bucketIndex = bucketIndex;
    }

    Node findNode(int hash) {
        Node currentNode = firstNode;
        while (currentNode != null) {
            if (currentNode.hash == hash) {
                break;
            }
            currentNode = currentNode.nextNode;
        }
        return currentNode;
    }

    void addNode(Node newNode) {

        if (firstNode == null) {
            firstNode = newNode;
        } else {
            Node currentNode = firstNode;
            while (true) {
                if (currentNode.hash == newNode.hash && currentNode.key.equals(newNode.key)) {
                    currentNode.value = newNode.value;
                    return;
                }
                if (currentNode.nextNode == null) {
                     currentNode.nextNode = newNode;
                     return;
                }
                currentNode = currentNode.nextNode;
            }
        }
    }

    void removeNode(String key) {

        if (firstNode == null) {
            throw new RuntimeException("Nothing to remove");
        } else if (firstNode.hash == key.hashCode() && firstNode.key.equals(key)) {
            firstNode = null;
        } else {
            Node currentNode = firstNode;
            Node nextNode = currentNode.nextNode;
            while (nextNode != null) {
                if (nextNode.hash == key.hashCode() && nextNode.key.equals(key)) {
                    currentNode.nextNode = nextNode.nextNode;
                    return;
                }
                currentNode = nextNode;
                nextNode = nextNode.nextNode;
            }
        }
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
        System.out.println("This is my HashMap implementation\n");
        HashMapImpl map = new HashMapImpl();
        map.put("key1", "v1");
        map.put("key2", "v2");
        map.put("key3", "v3");
        map.put("key4", "v4");
        map.printMap();

        System.out.println("Is k3 in the map: " + map.contains("k3"));
        map.remove("k3");
        System.out.println("Is k3 in the map: " + map.contains("k3"));

        map.put("key3", "v3");
        map.printMap();
    }
}
