package com.qsp.simple_sms_project.dao;

import com.qsp.simple_sms_project.dbconnection.DatabaseConnection;

import com.qsp.simple_sms_project.entity.Student;

import java.sql.*;
import java.util.*;

public class StudentDao {

	Connection con = DatabaseConnection.getDBConnection();
	
	public boolean saveStudent(Student std) {
		try {
			
			String query = "insert into student values(?,?,?,?,?,?)";
			PreparedStatement pstm = con.prepareStatement(query);
			
			pstm.setInt(1, std.getSid());
			pstm.setString(2, std.getName());
			pstm.setLong(3, std.getPhone());
			pstm.setString(4, std.getEmail());
			pstm.setString(5, std.getBranch());
			pstm.setString(6, std.getStream());
			
			int rows = pstm.executeUpdate();
			
			return rows > 0;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateStudent(int id,String name) {
		
		try {
			
			String query = "update student set name = ? where sid = ?";
			PreparedStatement  pstm = con.prepareStatement(query);
			
			pstm.setString(1, name);
			pstm.setInt(2, id);
			
			int rows = pstm.executeUpdate();
			
			return rows > 0;
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean deleteStudent(int id) {
		
		try {
			
			String query = "delete from student where sid = ?";
			PreparedStatement pstm = con.prepareStatement(query);
			
			pstm.setInt(1, id);
			
			int rows = pstm.executeUpdate();
			
			return rows > 0 ;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Student> fetchAll(){
		
		List<Student> stdList = new ArrayList<Student>();
		
		try {
			String query = "select * from student";
			PreparedStatement pstm = con.prepareStatement(query);
			
			ResultSet res = pstm.executeQuery();
			
			while(res.next()) {
				
				Student std2 = new Student();
				std2.setSid(res.getInt(1));
				std2.setName(res.getString(2));
				std2.setPhone(res.getLong(3));
				std2.setEmail(res.getString(4));
				std2.setBranch(res.getString(5));
				std2.setStream(res.getString(6));
				
				stdList.add(std2);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return stdList;
	}
	
	public Student fetchAllByID(int id) {
		
		try {
			
			String query = "select * from student where sid = ?";
			
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, id);
			
			ResultSet res1 = pstm.executeQuery();
			res1.next();
			Student std3 = new Student();
			
			std3.setSid(res1.getInt(1));
			std3.setName(res1.getString(2));
			std3.setPhone(res1.getLong(3));
			std3.setEmail(res1.getString(4));
			std3.setBranch(res1.getString(5));
			std3.setStream(res1.getString(6));
			
			return std3;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
