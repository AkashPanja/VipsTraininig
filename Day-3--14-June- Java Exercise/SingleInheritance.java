package com.bmpl.javabasic;


class Person{
	
	String name;
	int age;
	
	void show(){
		System.out.println("show() of Person");
	}
	
	void print(){
	//funcationlity	
	}
	
	void data(){
		
	}
	
	void calculation(){
		
	}
}

class Student extends Person{
	
	int temp = 10;
	String studName;
	int studAge;
	
	void studShow(){
		System.out.println("show() of Student");
	}

	@Override
	void print() {
		// TODO Auto-generated method stub
		super.print();
	}
	
	
	
	
	
	/*//annotation
	@Override
	void show(){
		System.out.println("show of Student class");
	}
	@Override
	void print(){
		
	}
	@Override
	void data(){
		
	}*/
}

class Employee extends Student{
	
	int temp  = 10;
	
	void print(){
		int temp = 20;
		temp = super.temp + this.temp + temp;
		super.studShow();
		System.out.println(temp);
		
	}
	
}

public class SingleInheritance {

	public static void main(String[] args) {
		Student ram = new Student();
		ram.studName = "";
		ram.show();
		ram.studShow();

	}
}