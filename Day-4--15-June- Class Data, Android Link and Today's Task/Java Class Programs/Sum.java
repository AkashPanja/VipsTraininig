package com.bmpl.javabasic;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Sum {

	
	public static void main(String[] args) {
	
		int value1 = 0, value2 = 0;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter first value");
		
		try{
		
		value1 = scanner.nextInt();
		
		System.out.println("Enter second value");
		value2 = scanner.nextInt();
		} 
		
		catch(InputMismatchException e){
			System.out.println("Enter only numeric values");
		}
		
		catch(Exception e){
			System.out.println("Enter only numeric values");
		}
		

		
		int result = value1 + value2;
		
		System.out.println("Result is=" +result);

	}

}
