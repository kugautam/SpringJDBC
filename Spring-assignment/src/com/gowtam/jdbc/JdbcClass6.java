package com.gowtam.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcClass6 {
	public static void main(String[] args) 
	{
		String url = "jdbc:mysql://localhost:3306";
		String user = "root";
		String password = "tree123";
		
		/*String query="select database.employee.empid,database.employee.empName,database.department.deptId,database.department.deptManagerId from database.employee,database.department WHERE database.employee.empId=database.department.deptId";*/
		
		String query="select * from database.employee,database.department WHERE database.employee.empId=database.department.deptId";
		
		Scanner scanner=new Scanner(System.in);
	
			try 
			{
				Connection connection=DriverManager.getConnection(url,user,password);
				System.out.println("Connection Established");
				
				Statement statement=connection.createStatement();
				
				System.out.println("Platform Created");	
				
				ResultSet resultSet=statement.executeQuery(query);				
				
				while(resultSet.next()) 
				{
					String empId=resultSet.getString("empid");
					String empName=resultSet.getString("empname");
					Date empHireDate=resultSet.getDate("emphiredate");
					String empSalary=resultSet.getString("empsalary");
					String empJobId=resultSet.getString("empjobid");
					String empDept=resultSet.getString("empdept");
					
					System.out.println("empId: "+empId+" empName: "
								+ ""+empName+" empHireDate: "+empHireDate+
								" empSalary: "+empSalary+" empJobId: "
							+ ""+empJobId+" empDept: "+empDept);	
				}
				
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}	
	}

}
