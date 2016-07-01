package com.gd.practice;

import java.util.HashSet;
import java.util.Set;

public class Boggle {

	public static void main(String[] args) {
		String[] sArr = {"abc", "abd", "abe", "asd", "abb"};
		Set<String> dictionary = Boggle.createDictionary(sArr);
		
		Character[][] matrix = {{'a','b','c'},{'a','c','d'}};
		
		Trie trie = Boggle.matrixToTrie(matrix);
	}

	static HashSet<String> createDictionary(String[] sArr) {
		HashSet<String> set = new HashSet<String>();
		for(int i=0; i<sArr.length; i++) {
			set.add(sArr[i]);
		}
		return set;
	}
	
	static Trie matrixToTrie(Character[][] matrix) {
		for(int i=0; i<matrix.length; i++) {
			
		}
		return null;
	}
}