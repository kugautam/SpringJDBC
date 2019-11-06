package com.gowtam.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcClass1 
{

		public static void main(String[] args) 
		{
			String url = "jdbc:mysql://localhost:3306";
			String user = "root";
			String password = "tree123";
			
			String query="select * from database.employee where EmpDept=?";
			
			Scanner scanner=new Scanner(System.in);
		
				try 
				{
					Connection connection=DriverManager.getConnection(url,user,password);
					System.out.println("Connection Established");
					
					PreparedStatement prepareStatement=connection.prepareStatement(query);
					System.out.println("Platform Created");
									
				
					System.out.println("Enter departmentId ");
				    String deptId=scanner.next();	
					
					prepareStatement.setString(1,deptId);
					
					ResultSet resultSet=prepareStatement.executeQuery();				
					
					while(resultSet.next()) 
					{
						String empId=resultSet.getString("empid");
						String empName=resultSet.getString("empname");
						Date empHireDate=resultSet.getDate("emphiredate");
						String empSalary=resultSet.getString("empsalary");
						String empJobId=resultSet.getString("empjobid");
						String empDept=resultSet.getString("empdept");
						
						if(empDept.equals(deptId)) 
						{
							System.out.println("Empoyee details with deptId: "+deptId);
							System.out.println("empId: "+empId+" empName: "
									+ ""+empName+" empHireDate: "+empHireDate+
									" empSalary: "+empSalary+" empJobId: "+empJobId+" empDept: "+empDept);
						}
					}
					
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}	
		}
	}
