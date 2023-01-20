package com.pojo;

public class Student {

	private int rollno;
	private String name;
	private int phone;
	private int age;
	private String city;
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//getter setter
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	//constructor
	public Student(int rollno, String name, int phone, int age, String city, String password) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.phone = phone;
		this.age = age;
		this.city = city;
		this.password = password;
	}
	
	//tostring
	@Override
	public String toString() {
		return "rollno=" + rollno + ", name=" + name + ", phone=" + phone + ", age=" + age + ", city=" + city;
	}
	
	
	
	
	
}
