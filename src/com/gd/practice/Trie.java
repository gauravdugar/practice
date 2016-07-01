package com.gd.practice;

import java.util.HashMap;

public class Trie {
	
	Node root = null;
	
	Trie() {
		this.root = new Node(null);
	}
	
	void addString(String s) throws Exception {
		if(s == null || s.isEmpty())
			throw new Exception("Null or empty string cannot be added to Trie.");
		
		char[] cArr = s.toCharArray();
		Node currNode = root;
		for(int i=0; i<cArr.length; i++) {
			if(!currNode.childMap.containsKey(cArr[i]))
				currNode.childMap.put(cArr[i], new Node(cArr[i]));
			currNode = currNode.childMap.get(cArr[i]);
		}
		currNode.endOfString = true;
	}
	
	boolean checkString(String s) throws Exception {
		if(s == null || s.isEmpty())
			throw new Exception("Null or empty string cannot be checked in Trie.");
		
		char[] cArr = s.toCharArray();
		Node currNode = root;
		for(int i=0; i<cArr.length; i++) {
			if(!currNode.childMap.containsKey(cArr[i]))
				return false;
			currNode = currNode.childMap.get(cArr[i]);
		}
		if(currNode.endOfString)
			return true;
		return false;
	}
}

class Node {
	
	Character value = null;
	boolean endOfString = false;
	
	HashMap<Character,Node> childMap = null;	
	
	Node(Character value) {
		this.childMap = new HashMap<Character,Node>();	
		this.value = value;
	}
}