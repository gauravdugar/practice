package com.gd.practice.ds.test;

class HashMapImpl {
    private int BUCKET_COUNT = 4;
    private int USED_BUCKET_COUNT = 0;

    private Node[] firstNodeArray;

    HashMapImpl() {
        firstNodeArray = new Node[BUCKET_COUNT];
    }

    void put(String key, String value) {
        if (key == null) {
            throw new RuntimeException("null key is not supported.");
        }
        Node newNode = new Node(key, value, key.hashCode());
        int bucketIndex = getBucketIndexByKey(key);
        System.out.println("Adding {" + key + ", " + value + "} to bucket " + bucketIndex);

        if (firstNodeArray[bucketIndex] == null) {
            firstNodeArray[bucketIndex] = newNode;
            USED_BUCKET_COUNT++;
            rearrange();
        } else {
            Node currentNode = firstNodeArray[bucketIndex];
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

    String get(String key) {
        Node n = findNode(key);
        return n == null ? null : n.value;
    }

    boolean contains(String key) {
        return findNode(key) != null;
    }

    private Node findNode(String key) {
        if (key == null) {
            throw new RuntimeException("null key is not supported.");
        }
        int bucketIndex = getBucketIndexByKey(key);
        int hash = key.hashCode();

        Node currentNode = firstNodeArray[bucketIndex];
        while (currentNode != null) {
            if (currentNode.hash == hash) {
                break;
            }
            currentNode = currentNode.nextNode;
        }
        return currentNode;
    }

    void remove(String key) {
        if (key == null) {
            throw new RuntimeException("null key is not supported.");
        }
        int bucketIndex = getBucketIndexByKey(key);

        if (firstNodeArray[bucketIndex] == null) {
            throw new RuntimeException("Nothing to remove");
        } else if (firstNodeArray[bucketIndex].hash == key.hashCode() && firstNodeArray[bucketIndex].key.equals(key)) {
            firstNodeArray[bucketIndex] = null;
            USED_BUCKET_COUNT--;
        } else {
            Node currentNode = firstNodeArray[bucketIndex];
            Node nextNode = currentNode.nextNode;
            while (nextNode != null) {
                if (nextNode.hash == key.hashCode() && nextNode.key.equals(key)) {
                    currentNode.nextNode = nextNode.nextNode;
                    return;
                }
                currentNode = nextNode;
                nextNode = nextNode.nextNode;
            }
            throw new RuntimeException("Nothing to remove");
        }
    }

    private void rearrange() {
        int usedBucketPercentage = (USED_BUCKET_COUNT * 100) / BUCKET_COUNT;
        if (usedBucketPercentage < 75) {
            return;
        }

        System.out.println(usedBucketPercentage + "% buckets are full. Rearranging HashMap now.");

    }

    private int getBucketIndexByKey(String key) {
        int hashCode = key.hashCode();
        return hashCode % BUCKET_COUNT;
    }

    void printMap() {
        System.out.println("\nBucket Count: " + BUCKET_COUNT + "\n");

        for (int i = 0; i < firstNodeArray.length; i++) {
            System.out.println("Bucket " + i);
            Node currentNode = firstNodeArray[i];
            while (currentNode != null) {
                System.out.println(currentNode);
                currentNode = currentNode.nextNode;
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
        map.put("k2", "v2");
        map.put("k3", "v3");
        map.put("k4", "v4");
        map.put("k5", "v5");
        map.put("k6", "v6");
        map.printMap();
        System.out.println("value of k2 in the map: " + map.get("k2"));
        System.out.println("Is k3 in the map: " + map.contains("k3"));
        map.remove("k3");
        System.out.println("Is k3 in the map: " + map.contains("k3"));
        map.put("k2", "v2-new");
        System.out.println("value of k2 in the map: " + map.get("k2"));
        map.printMap();
    }
}
