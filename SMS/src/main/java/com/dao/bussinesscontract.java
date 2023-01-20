package com.dao;
import java.sql.SQLException;
import java.util.List;

import com.pojo.Student;

public interface bussinesscontract {

	public int RegisterStudent(int rollno,String name,int phone,int age,String city,String password) throws SQLException;
	
	public Student ValidateStudent(int rollno,String password) throws SQLException;
	
	public Student GetByRollNo(int id) throws SQLException;
	
	public List<Student> GetAllStudents() throws SQLException;
	
}
