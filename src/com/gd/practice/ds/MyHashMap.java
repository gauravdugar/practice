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
    //LinkedList<Node> list = new LinkedList<Node>();
    Node firstNode;


    public void addNode(Node node){
        //Nothing is there yet
        if(firstNode == null){
            firstNode = node;
        }

        Node currentNode = firstNode;
        //case exists, and case not exists and the same time
        while (currentNode != null){
            if(currentNode.hash == node.hash){
                currentNode.value = node.value;
                break;
            }
            if(currentNode.next == null){
                currentNode.next = node;
                break;
            }
            currentNode = currentNode.next;
        }
    }

    /**
 -    * Find if a given key's hash exists in the hashtable
     * @param hash
     * @return the node where the hash exits within the table
     */
    public Node findKey(int hash){
        Node current = firstNode;

        while (current != null){
            if(current.hash == hash){
                //returning a node because this makes the most since when we want to use it
                // in the Hashmap class methods
                break;
            }
            current = current.next;

        }
        return current;
    }
}

class Node {
    // how do we prevent them from being hacked, or follow safe practice
    // because I know that an object's state show always be private for security reasons
    String key;
    String value;
    int hash;
    Node next;

    Node(){
        this.key = key;
        this.value = value;
        this.hash = hash;
        this.next = next;
    }
    Node(String key, String value, int hash) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;

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
