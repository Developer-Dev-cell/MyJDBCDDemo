
package com.mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SetUp {

	//add mysql connector jar file = for mysql database connection into the project.
 	public void creatDatabase() {
	
			//Connection Establish
			try {
				
				String url = "jdbc:mysql://localhost:3306/";  //Here if not import port still it will run = jdbc:mysql://localhost/
				String username = "root";
				String password = "Monicamysql@123";
				
				Connection conn = DriverManager.getConnection(url, username, password);	
				Statement stm = conn.createStatement();
			//	System.out.println("Connected successfully");
				String query = "create database TNSDatabase ";
				stm.execute(query);
				System.out.println("Database created successfully");
				
			}catch (Exception e) {
				e.printStackTrace();
			}
	}   
			
			public void createTable() {
				// TODO Auto-generated method stub
				try
				{
					
					String url = "jdbc:mysql://localhost:3306/";  //For port select @@Port; run it on sql cmd to verify
					String db = "TNSDatabase";
					String username = "root";  //Select user(); run it sql cmd to verify
					String password = "Monicamysql@123";
					
					Connection conn = DriverManager.getConnection(url+db, username, password);	
					Statement stm = conn.createStatement();
			
					String query = "create table student (sid int(3), sname varchar(200), semail varchar(200)) ";
					stm.execute(query);
					System.out.println("Table created successfully");
					
				}catch (Exception e) {
					e.printStackTrace();
				}
	 }                 
	
	
			public void insertData() {
				// TODO Auto-generated method stub
				try
				{
					
					String url = "jdbc:mysql://localhost:3306/";
					String db = "TNSDatabase";
					String username = "root";
					String password = "Monicamysql@123";
					
					Connection conn = DriverManager.getConnection(url+db, username, password);		
					String query = "INSERT into student (sid, sname, semail) VALUES (?,?,?)";
					
					PreparedStatement pstm = conn.prepareStatement(query);
					pstm.setInt(1, 11);
					pstm.setString(2, "Rajesh");
					pstm.setString(3, "rajesh@gmail.com");
			
//					PreparedStatement pstm2 = conn.prepareStatement(query);
//					pstm2.setInt(1, 102);
//					pstm2.setString(2, "Priya");
//					pstm2.setString(3, "Priya@gmail.com");
			
				   		
				//  pstm.execute();    
				    pstm.executeUpdate();
				    System.out.print("Values inserted Successfully");
				    conn.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
        }
			
			public void readData() {
				// TODO Auto-generated method stub
			
				try
				{
					String url = "jdbc:mysql://localhost:3306/";
					String db = "TNSDatabase";
					String username = "root";
					String password = "Monicamysql@123";
					
					Connection conn = DriverManager.getConnection(url+db, username, password);		
					String query = "Select * from student";
					
					Statement stm = conn.createStatement();
					
				    ResultSet rs = stm.executeQuery(query);
				    while(rs.next()) {
				    	System.out.println("id = "+rs.getInt(1));
				    	System.out.println("name = "+rs.getString(2));
				    	System.out.println("email = "+rs.getString(3));
				    }
				    
				    System.out.print("Read Successfully" );
				    conn.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
							
		}
			
			public void updateData() {
				// TODO Auto-generated method stub
			
				try
				{
					String url = "jdbc:mysql://localhost:3306/";
					String db = "TNSDatabase";
					String username = "root";
					String password = "Monicamysql@123";
					
					Connection conn = DriverManager.getConnection(url+db, username, password);		
					String query = "UPDATE student set sid = ? where sname = ?";
					
					PreparedStatement pstm = conn.prepareStatement(query);
					pstm.setInt(1, 11);
					pstm.setString(2, "Monica");
				  //pstm.setString(3, "monica@gmail.com");
					
				 	
				    pstm.execute();
				    System.out.print("Data updated Successfully");
				    conn.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
				
				public void deleteData() {
					// TODO Auto-generated method stub
					
					try
					{
						String url = "jdbc:mysql://localhost:3306/";
						String db = "TNSDatabase";
						String username = "root";
						String password = "Monicamysql@123";
						
						Connection conn = DriverManager.getConnection(url+db, username, password);		
						String query = "DELETE from student where sid = '101'";
						
						PreparedStatement pstm = conn.prepareStatement(query);
						
					   
					    pstm.execute(query);
					    System.out.print("Data Value deleted Successfully");
					    conn.close();
					}catch (Exception e) {
						e.printStackTrace();
					}
				
		}
//				mysql> Select user();
//				+----------------+
//				| user()         |
//				+----------------+
//				| root@localhost |
//				+----------------+
//				1 row in set (0.01 sec)
//
//				mysql> Select @@Port;
//				+--------+
//				| @@Port |
//				+--------+
//				|   3306 |
//				+--------+
//				1 row in set (0.01 sec)
			
}
