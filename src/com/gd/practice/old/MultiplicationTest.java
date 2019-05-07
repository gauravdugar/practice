package com.gd.practice.old;

import java.util.Arrays;

public class MultiplicationTest {
	
	private static void calculate(int[] arr) {
		
		int[] arr2 = new int[arr.length];
		
		int tempMul = 1;
		for(int i=0 ; i<arr.length - 1; i++) {
			arr2[i] = tempMul * arr[i];
			tempMul = arr2[i];
		}
		
		tempMul = 1;
		for(int i=arr.length - 1; i>0; i--) {
			arr2[i] = arr2[i-1] * tempMul;
			tempMul = tempMul * arr[i];
		}
		
		arr2[0] = tempMul;
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));
	}
	
	public static void main(String[] args) {
		int[] test = new int[] {1,2,3,4,5,6,7};
		MultiplicationTest.calculate(test);
	}
}
