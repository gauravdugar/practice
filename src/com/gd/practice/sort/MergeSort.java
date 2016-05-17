package com.gd.practice.sort;

import java.util.Arrays;

public class MergeSort {
	
	public static int[] f1(int[] arr) {
		
		if(arr.length <=2)
			return f2(arr);
	
		int[] arr1 = Arrays.copyOfRange(arr, 0, arr.length/2);
		int[] arr2 = Arrays.copyOfRange(arr, arr.length/2, arr.length);
		
		System.out.println(Arrays.toString(arr1) + " : " + Arrays.toString(arr2));
		
		return f3(f1(arr1),f1(arr2));
	}
	
	public static int[] f2(int[] arr) {
		if(arr.length == 2 && arr[0] > arr[1]) {
			int temp = arr[0];
			arr[0] = arr[1];
			arr[1] = temp;
		}
		return arr;
	}
	
	public static int[] f3(int[] arr1, int[] arr2) {
		
		int[] mergedArr = new int[arr1.length + arr2.length];
		int i=0, j=0;

		while( (i+j) < mergedArr.length) {

			if(i==arr1.length) {
				mergedArr[i+j] = arr2[j];
				j++;
			}
			else if(j==arr2.length) {
				mergedArr[i+j] = arr1[i];
				i++;
			}
			else if(arr1[i] <= arr2[j]) {
				mergedArr[i+j] = arr1[i];
				i++;
			} else {
				mergedArr[i+j] = arr2[j];
				j++;
			}
		}
		
		return mergedArr;
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{10,20,50,30,90,50,-10};
		int[] sortedArr = f1(array);
		System.out.println("Result: " + Arrays.toString(sortedArr));
	}

}
