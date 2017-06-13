package com.bmpl.javabasic;

import java.util.Scanner;

public class Actor {

	//states
	String name;
	int noOfHits;
	
	Scanner scanner = new Scanner(System.in);
	
	//behaviour
	void input(){
	
		System.out.println("Enter Actor's name");
		name = scanner.next();
	

		System.out.println("Enter No of hits");
		noOfHits = scanner.nextInt();
	}
	
	void description(){
		//user input
		
		System.out.println("Name is=" +name);
	
		System.out.println("No of hits are = "+noOfHits);
	}
	
	public static void main(String[] args) {
		
		//object
		Actor actor = new Actor();
		//actor.name  = "amitabh";
		actor.input();
		actor.description();
	}

}
