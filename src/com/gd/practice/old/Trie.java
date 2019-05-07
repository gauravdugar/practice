package com.gd.practice.old;

import java.util.HashMap;

class Trie {
	
	private Node root;
	
	Trie() {
		this.root = new Node(null);
	}
	
	void addString(String s) throws Exception {
		if(s == null || s.isEmpty())
			throw new Exception("Null or empty string cannot be added to Trie.");
		
		char[] cArr = s.toCharArray();
		Node currNode = root;
		for (char c : cArr) {
			if(!currNode.childMap.containsKey(c))
				currNode.childMap.put(c, new Node(c));
			currNode = currNode.childMap.get(c);
		}
		currNode.endOfString = true;
	}
	
	boolean checkString(String s) throws Exception {
		if(s == null || s.isEmpty())
			throw new Exception("Null or empty string cannot be checked in Trie.");
		
		char[] cArr = s.toCharArray();
		Node currNode = root;
		for (char c : cArr) {
			if(!currNode.childMap.containsKey(c))
				return false;
			currNode = currNode.childMap.get(c);
		}
		return currNode.endOfString;
	}
}

class Node {
	
	private Character value;
	boolean endOfString = false;
	
	HashMap<Character,Node> childMap;
	
	Node(Character value) {
		this.childMap = new HashMap<>();
		this.value = value;
	}
}