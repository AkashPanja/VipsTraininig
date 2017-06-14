package com.bmpl.javabasic;


abstract class Bank{
	
	
	void deposit(){
	}
	
	void withdraw(){
		
	}
	
	void balance(){
		System.out.println("show bal.");
	}
	
	abstract void rateOfInterest();	
}

class HDFC extends Bank{

	@Override
	void rateOfInterest() {
		// TODO Auto-generated method stub
		
	}
	
	
}


public class AbstractionDemo {

	public static void main(String[] args) {
	
		//Bank bank = new Bank();
		//bank.rateOfInterest();
	}

}









