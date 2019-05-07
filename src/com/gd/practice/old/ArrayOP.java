package com.gd.practice.old;

public class ArrayOP {

	public enum OP { GTE, GT, E, LT, LTE}
	
	public static void main(String[] args) {
		
		int[] arr = new int[] {10,20,30,40,50};
		OP op = OP.LT;
		int value = 55;			
		System.out.println("Result index: " + ArrayOP.solution(arr, op, value));
	}
	
	private static int solution(int[] arr, OP op, int value) {
		
		// checking if array is empty.
		if(arr.length < 1)
			return -1;
		
		// running loop for binary search
		int start = 0;
		int end = arr.length - 1;
		int mid = 0;
		
		while(end >= start) {
			mid = (start + end) / 2;
			if(arr[mid] == value) {
				break;
			}
			if(arr[mid] < value) {
				start = mid + 1;
			}
			if(arr[mid] > value) {
				end = mid - 1;
			}
		}
		
		// checking equals condition for E, GTE, LTE
		if(op == OP.E || op == OP.GTE || op == OP.LTE) {
			if(arr[mid] == value)
				return mid;
		}
		
		// getting index of closest item in array
		if(op == OP.E) {
			if(mid > 0 && Math.abs(arr[mid-1]-value) < Math.abs(arr[mid]-value))
				return mid-1;
			if(mid < arr.length-1 && Math.abs(arr[mid]-value) > Math.abs(arr[mid+1]-value))
				return mid+1;
			return mid;
		}

		// getting smallest "larger than value" item from array. 
		if(op == OP.GT || op == OP.GTE) {
			if(mid == arr.length-1 && arr[mid] <= value)
				return -1;
			if(arr[mid] <= value)
				return mid+1;
			return mid;
		}
			
		// getting largest "smaller than value" item from array. 
		if(op == OP.LT || op == OP.LTE) {
			if(mid == 0 && arr[mid] >= value)
				return -1;
			if(arr[mid] >= value)
				return mid-1;
			return mid;
		}
		
		return -1;
	}
	
}
