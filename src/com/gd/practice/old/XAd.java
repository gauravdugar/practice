package com.gd.practice.old;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XAd {

	public static void main(String args[]) {
		List<Block> input = new ArrayList<>();
		input.add(new Block(1, "C", 2));
		input.add(new Block(2, "B", 3));
		input.add(new Block(3, "A", 0));
		input.add(new Block(4, "D", 2));
		input.add(new Block(5, "E", 0));
		input.add(new Block(6, "F", 5));
		
		XAd.printTree(input);
	}
	
	private static void printTree(List<Block> input) {
		Map<Integer,List<Block>> map = new HashMap<>();
		
		int maxId = 0;
		for (Block b : input) {
			int parent = b.parent;
			int id = b.id;
			if(id > maxId)
				maxId = id;
			
			if(map.containsKey(parent)) {
				List<Block> tempList = map.get(parent);
				tempList.add(b);
			} else {
				List<Block> tempList = new ArrayList<>();
				tempList.add(b);
				map.put(parent, tempList);
			}
		}
		
		if(!map.containsKey(0)) {
			System.out.println("Empty input");
			return;
		}
		
		XAd.recPrint(map, 0, "");
	}
	
	private static void recPrint(Map<Integer,List<Block>> map, int id, String spaces) {
		List<Block> tempList = map.get(id);
		if(tempList == null)
			return;
		for (Block b : tempList) {
			System.out.println(spaces + b.value);
			XAd.recPrint(map, b.id, spaces + "  ");
		}
	}
}

class Block {
	int id;
	String value;
	int parent;
	
	Block(int id, String value, int parent) {
		this.id = id;
		this.value = value;
		this.parent = parent;
	}
}