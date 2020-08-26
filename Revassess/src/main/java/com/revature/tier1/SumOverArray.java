package com.revature.tier1;

public class SumOverArray {

	public static int IterateAndSum(int[] arr) {
		int sum=0;
		for (int i =0; i <arr.length; i ++) {
			//System.out.println("arr i : "+ arr[i]);
			sum = sum+ arr[i];
			//System.out.println("sum:" +sum);
		}
		return sum;
	}
}
