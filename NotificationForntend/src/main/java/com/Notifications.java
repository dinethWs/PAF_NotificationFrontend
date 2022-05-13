package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement; 

public class Notification { 
	//Common method to connect to the DB
		private Connection connect(){ 
			
						Connection con = null; 
						
						try{ 
								Class.forName("com.mysql.jdbc.Driver"); 
 
								//Provide the correct details: DBServer/DBName, username, password 
								con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/powereg", "root", ""); 
						} 
						catch (Exception e) {
							e.printStackTrace();
							} 
						
						return con; 
			} 
		
		
		public String insertNotification(String notificationCode, String message, String date, String timePeriod, String area, String establishedBy){ 
			
					String output = ""; 
					
					try
					{ 
						Connection con = connect(); 
						
						if (con == null) 
						{
							return "Error while connecting to the database for inserting."; 
							
						} 
						// create a prepared statement
						
						String query = "insert into interruption (notificationId, notificationCode, message, date, timePeriod, area, establishedBy)" + " values (?, ?, ?, ?, ?, ?, ?)";
						PreparedStatement preparedStmt = con.prepareStatement(query); 
						// binding values
						 preparedStmt.setInt(1, 0);
						 preparedStmt.setString(2, notificationCode);
						 preparedStmt.setString(3, message);
						 preparedStmt.setString(4, date);
						 preparedStmt.setString(5, timePeriod);
						 preparedStmt.setString(6, area);
						 preparedStmt.setString(7, establishedBy);
						// execute the statement
 
						preparedStmt.execute(); 
						con.close(); 
						
						String newNotifications = readNotifications(); 
						output = "{\"status\":\"success\",\"data\":\""+newNotifications+"\"}"; 
					} 
					
					catch (Exception e) 
					{ 
						output = "{\"status\":\"error\", \"data\":\"Error while inserting the Notification.\"}"; 
						System.err.println(e.getMessage()); 
					} 
					return output; 
			} 
			
			
			
			
} 

