package com.qsp.simple_sms_project.controller;

import java.util.List;
import java.util.Scanner;

import com.qsp.simple_sms_project.dao.StudentDao;
import com.qsp.simple_sms_project.entity.Student;

public class StudentContoller {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		StudentDao dao = new StudentDao();
		
		do {
			System.out.println("--------WELCOME TO STUDENT MANAGEMENT SYSTEM---------");
			System.out.println("Enter your choice :");
			System.out.println("1.Insert the data");
			System.out.println("2.Update the data");
			System.out.println("3.Delete the data");
			System.out.println("4.Retreive All the data");
			System.out.println("5.Retreive the data based on sid");
			System.out.println("6. Exit from Application");
			
			int choice = sc.nextInt();
			
			switch(choice) {
				
			case 1:
				
				System.out.println("Enter sid :");
				int sid = sc.nextInt();
				System.out.println("Enter phone :");
				long phone = sc.nextLong();
				sc.nextLine();
				System.out.println("Enter name :");
				String name = sc.next();
				System.out.println("Enter email :");
				String email = sc.next();
				System.out.println("Enter branch :");
				String branch = sc.next();
				System.out.println("Enter stream :");
				String stream = sc.next();
				
				Student std = new Student();
				std.setSid(sid);
				std.setName(name);
				std.setEmail(email);
				std.setPhone(phone);
				std.setBranch(branch);
				std.setStream(stream);
				
				boolean b = dao.saveStudent(std);
				
				if(b) {
					System.out.println("Data is Inserted....");
				}else {
					System.out.println("Data is not Inserted....");
				}
				
			break;
				
			case 2:
				
				System.out.println("Enter sid: ");
				int stdid = sc.nextInt();
				System.out.println("Enter name: ");
				String sname = sc.next();
				
			    boolean b1 = dao.updateStudent(stdid, sname);
			    
			    if(b1) {
			    	System.out.println("Data is Updated....");
			    }else {
			    	System.out.println("Data is not Updated....");
			    }
				
			break;
			
			case 3:
				
				System.out.println("Enter sid");
				int stid = sc.nextInt();
				
				boolean b3 = dao.deleteStudent(stid);
				
				if(b3) {
					System.out.println("Data is deleted....");
				}else {
					System.out.println("Data is not deleted....");
				}
				
			break;
			
			case 4:
				
				List<Student> stdList = dao.fetchAll();
				
				if(stdList == null) {
					System.out.println("No Data present in student table");
				}
				else {
					
					for(Student stds : stdList) {
					
						System.out.println("sid : "+stds.getSid());
						System.out.println("name : "+stds.getName());
						System.out.println("phone : "+stds.getPhone());
						System.out.println("email : "+stds.getEmail());
						System.out.println("branch : "+stds.getBranch());
						System.out.println("stream : "+stds.getStream());
						System.out.println("-------------------------");
					}
				}
			break;
			
			case 5:
				
				System.out.println("Enter sid : ");
				int stdsid = sc.nextInt();
				
				Student std2 = dao.fetchAllByID(stdsid);
				
				if(std2 == null) {
					System.out.println("No Data present in student table");
				}
				else {
		
						System.out.println("sid : "+std2.getSid());
						System.out.println("name : "+std2.getName());
						System.out.println("phone : "+std2.getPhone());
						System.out.println("email : "+std2.getEmail());
						System.out.println("branch : "+std2.getBranch());
						System.out.println("stream : "+std2.getStream());
						System.out.println("-------------------------");
				}
				
			break;
			
			case 6:
				System.out.println("Exited from Application");
				System.exit(0);
			break;
			
			default : 
				System.err.println("Invalid Choice");
			break;
			
			}
			
		}while(true);
	}
}
