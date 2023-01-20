package com.dao;
import static com.util.Dbutils.con;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Student;
import com.util.Dbutils;

public class StudentContractImpl implements bussinesscontract {
	
	private PreparedStatement ps1,ps2,ps3,ps4;
	private ResultSet rset;
	private Connection con;
	
	public StudentContractImpl() throws SQLException {
		
		con=Dbutils.getCon();
		ps1=con.prepareStatement("insert into student values(?,?,?,?,?,?);");
		ps2=con.prepareStatement("select * from student where rollno=? and password=?;");
		ps3=con.prepareStatement("select * from student where rollno=?;");
		ps4=con.prepareStatement("select * from student;");
				
	}

	@Override
	public int RegisterStudent(int rollno, String name, int phone, int age, String city,String password) throws SQLException {
		// TODO Auto-generated method stub
		ps1.setInt(1,rollno);
		ps1.setString(2,name);
		ps1.setInt(3,phone);
		ps1.setInt(4,age);
		ps1.setString(5,city);
		ps1.setString(6,password);		
		
		//public Student(int rollno, String name, int phone, int age, String city, String password)
		Student stud=new Student(rollno,name,phone,age,city,password);
		
		ps1.executeUpdate();
		return stud.getRollno();	
	}

	@Override
	public Student ValidateStudent(int rollno, String password) throws SQLException {
		ps2.setInt(1, rollno);
		ps2.setString(2,password);
		rset=ps2.executeQuery();
		Student obj=null;
		if(rset.next()) {
			//public Student(int rollno, String name, int phone, int age, String city, String password)
			obj=new Student(rset.getInt("rollno"),rset.getString("name"),
					rset.getInt("phone"),rset.getInt("age"),rset.getString("city"),rset.getString("password"));
		}
				
		return obj;
	}

	@Override
	public Student GetByRollNo(int id) throws SQLException {
		ps3.setInt(1,id);
		rset=ps3.executeQuery();
		Student obj=null;

		if(rset.next()) {
			//public Student(int rollno, String name, int phone, int age, String city, String password)
			obj=new Student(rset.getInt("rollno"),rset.getString("name"),
					rset.getInt("phone"),rset.getInt("age"),rset.getString("city"),rset.getString("password"));
		}
				
		return obj;
	}

	@Override
	public List<Student> GetAllStudents() throws SQLException {
		// TODO Auto-generated method stub
		List<Student> studlist=new ArrayList<>();
		rset=ps4.executeQuery();
		Student stud=null;
		while(rset.next()) {
			stud=new Student(rset.getInt("rollno"),rset.getString("name"),
					rset.getInt("phone"),rset.getInt("age"),rset.getString("city"),rset.getString("password"));
			
			studlist.add(stud);
		}
		return studlist;
	}

}
