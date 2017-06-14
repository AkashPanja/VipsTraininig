package com.bmpl.javabasic;
public class Demo {

	int rollno;
	String name;
	String collegeName;
	float percentage;
	
	Demo(){
		collegeName = "VIPS";
	}
	
	Demo(float percentage){
		this();//default cons calling
		this.percentage = percentage;
	}	
	//default cons
	Demo(int rollno, String name){
		this(78.3f);
		this.rollno = rollno;
		this.name = name;
	}
	
	void print(){
		System.out.println("Name is="+name);
		System.out.println("Rollno is="+rollno);
		System.out.println("Percentage is="+percentage);
		System.out.println("College Name is="+collegeName);
	}
	
	public static void main(String[] args) {
		
		Demo demo1 = new Demo(1, "Ram");
		demo1.print();
	}
}