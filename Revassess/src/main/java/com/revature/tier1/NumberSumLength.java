package com.revature.tier1;

import java.util.ArrayList;

public class NumberSumLength {

	public static boolean checkNumberPowerLength(long num) {
		int power = 0;
		int sum =0;
		int count=0;
		long temp=num;
		int digit;
		long num1=num;
		while(num > 0)
        {
            num= num / 10;
            count++;
        }
        while(temp > 0)
        {
            digit = (int) (temp % 10);
           // System.out.println("Digit at place "+count+" is: "+digit);
            
            power= (int) Math.pow(digit, count);
           // System.out.println("power:" + power);
            sum= sum+power;
           // System.out.println("sum: "+ sum);
            temp = temp / 10;
            count--;
        }
        //System.out.println("num: "+ num1+ " sum: "+ sum);
        
		if ((int)num1 ==sum) {
		    System.out.println("true");
			return true;
		}else {
			 System.out.println("false");
			return false;
		}
	}
}
