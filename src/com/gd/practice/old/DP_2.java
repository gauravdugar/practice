package com.gd.practice.old;

import java.util.Arrays;

public class DP_2 {

	private static int[][] arrMin = null;
	private static int[][] arrMax = null;
	
	private static void calculateArray(int[] arr, int k) {
		for(int x=0; x<arr.length-k; x++) {
			for(int i=arr.length-2-x, j=1; j<=k; i--,j++) {
				arrMin[i][j] = Math.min( Math.min(
					arr[i] * arrMin[i+1][j-1],
					arr[i] * arrMax[i+1][j-1]), arrMin[i+1][j]);
			
				arrMax[i][j] = Math.max( Math.max(
					arr[i] * arrMin[i+1][j-1],
					arr[i] * arrMax[i+1][j-1]), arrMax[i+1][j]);
			}
		}
	}
	
	private static void calculate(int[] arr, int k) {
		arrMin = new int[arr.length][k+1];
		arrMax = new int[arr.length][k+1];

		//setting all values to 1 for k=0 in both arrays
		for(int i=0; i<arr.length; i++) {
			arrMin[i][0] = 1;
			arrMax[i][0] = 1;
		}
		
		//setting minimum number values for each column (k) as all number multiplication
		int temp = 1;
		for(int i=arr.length-1,j=1; i>=0 && j<=k; i--,j++) {
			temp = temp * arr[i];
			arrMin[i][j] = temp;
			arrMax[i][j] = temp;
		}
		
		calculateArray(arr, k);
		printArrays();
	}
	
	private static void printArrays() {
		System.out.println("\nMin value array");
		for (int[] array : arrMin) {
			System.out.println(Arrays.toString(array));
		}
		System.out.println("\nMax value array");
		for(int[] array : arrMax) {
			System.out.println(Arrays.toString(array));
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {-2, -5, 3, 4};
		int k = 2;
		calculate(arr, k);
		System.out.println("\nMax multiplication = " + arrMax[0][k]);
		System.out.println("\nMin multiplication = " + arrMin[0][k]);
	}

}
