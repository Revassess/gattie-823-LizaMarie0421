package com.revature.tier1;

import java.util.ArrayList;

public class NumberSumLength {

	public static boolean checkNumberPowerLength(long num) {
		int power = 0;
		int sum =0;
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		do{
		    array.add((int) (num % 10));
		    num /= 10;
		} while  (num > 0);
		
		for(int i =0; i <array.size();i++) {
			power = (int) Math.pow(array.get(i), array.size());
			sum= sum+ power;
			//System.out.println(sum);
		}
		Long l= new Long(sum);
		if (l.equals(num)) {
		    System.out.println("true");
			return true;
		}else {
			return false;
		}
	}
}
