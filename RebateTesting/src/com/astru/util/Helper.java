package com.astru.util;

public class Helper {

	public static void main(String[] args) {
		
		
		
		Float pr = 3000f;
		Float inr = 17.5f;
		
		
		
		
		
		Float A = pr + pr*inr*0.5f/100;
		
		System.out.println(A);
		
		Float totalTaxPercentage = 17.5f;
		
		Integer totalDaysForSt = 182;
		
		Float P = 365*100*A/(36500+totalTaxPercentage*totalDaysForSt);

		System.out.println(P);
	}

}
