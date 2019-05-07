package com.gd.practice.old;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Boggle {

	public static void main(String[] args) {
		String[] sArr = {"abc", "abd", "abe", "asd", "abb"};
		Set<String> dictionary = Boggle.createDictionary(sArr);
		
		Character[][] matrix = {{'a','b','c'},{'a','c','d'}};
		
		Trie trie = Boggle.matrixToTrie(matrix);
	}

	private static HashSet<String> createDictionary(String[] sArr) {
		HashSet<String> set = new HashSet<>();
		Collections.addAll(set, sArr);
		return set;
	}
	
	private static Trie matrixToTrie(Character[][] matrix) {
		for(Character[] charArray : matrix) {
			System.out.println("charArray: " + Arrays.toString(charArray));
		}
		return null;
	}
}