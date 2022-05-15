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
		
		
		
		public String readNotifications() 
		{ 
			String output = ""; 
			try
			{ 
				Connection con = connect(); 
		 if (con == null) 
		 { 
		 return "Error while connecting to the database for reading."; 
		 } 
		 // Prepare the html table to be displayed
		 output = "<table border=\"1\" class=\"table\"><tr>"
		 		+ "<th>Notification Code</th>"
		 		+ "<th>Message</th>"
		 		+ "<th>Date</th>"
		 		+ "<th>Time Period</th>"
		 		+ "<th>Area</th>"
		 		+ "<th>Established By</th>"
		 		+ "<th>Update</th>"
		 		+ "<th>Remove</th></tr>"; 
		
		 String query = "select * from interruption"; 
		 Statement stmt = con.createStatement(); 
		 ResultSet rs = stmt.executeQuery(query); 
		 // iterate through the rows in the result set
		 while (rs.next()) 
		 { 
			    String notificationId = Integer.toString(rs.getInt("notificationId"));
				String notificationCode = rs.getString("notificationCode");
				String message = rs.getString("message");
				String date = rs.getString("date");
				String timePeriod = rs.getString("timePeriod");
				String area = rs.getString("area");
				String establishedBy = rs.getString("establishedBy");
		 
		 // Add into the html table
		 output += "<tr><td><input id='hidItemIDUpdate' name='hidItemIDUpdate' type='hidden' value='"+notificationId+"'>"+notificationCode+"</td>"; 
		 output += "<td>" + message + "</td>"; 
		 output += "<td>" + date + "</td>"; 
		 output += "<td>" + timePeriod + "</td>";
		 output += "<td>" + area + "</td>";
		 output += "<td>" + establishedBy + "</td>";
		 // buttons
		 output += "<td><input name='btnUpdate' type='button' value='Update' "
				 + "class='btnUpdate btn btn-secondary' data-itemid='" + notificationId + "'></td>"
				 + "<td><input name='btnRemove' type='button' value='Remove' "
				 + "class='btnRemove btn btn-danger' data-itemid='" + notificationId + "'></td></tr>"; 
		 
		 } 
		 con.close(); 
		 // Complete the html table
		 output += "</table>"; 
		 } 
		 
		catch (Exception e) 
		 { 
		 output = "Error while reading the Notifications."; 
		 System.err.println(e.getMessage()); 
		 } 
		return output; 
		}

		//update	
			
			public String updateNotification(String notificationId, String notificationCode, String message, String date, String timePeriod, String area, String establishedBy){ 
				
				String output = ""; 
					
				try{ 
						Connection con = connect(); 
						if (con == null){
								return "Error while connecting to the database for updating.";
							} 
						// create a prepared statement
						String query = "UPDATE interruption SET notificationCode=?, message=?, date=?, timePeriod=?, area=?, establishedBy=? WHERE notificationId=?"; 
						PreparedStatement preparedStmt = con.prepareStatement(query);
						
						// binding values
						preparedStmt.setString(1, notificationCode);
						preparedStmt.setString(2, message);
						preparedStmt.setString(3, date);
						preparedStmt.setString(4, timePeriod);
						preparedStmt.setString(5, area);
						preparedStmt.setString(6, establishedBy);
						preparedStmt.setInt(7, Integer.parseInt(notificationId));
						
						// execute the statement
						preparedStmt.execute(); 
						con.close(); 
						String newNotifications = readNotifications(); 
						output = "{\"status\":\"success\",\"data\":\""+newNotifications+"\"}"; 

					} 
					
					catch (Exception e){ 
						
						output = "{\"status\":\"error\",\"data\":\"Error while updating the Notifiaction.\"}"; 
						System.err.println(e.getMessage()); 						
					} 
					
					return output; 
			} 
			
			
			public String deleteNotification(String notificationId){ 
					String output = ""; 
					
					try{ 
						Connection con = connect(); 
						
						if (con == null){
							return "Error while connecting to the database for deleting."; 
							} 
						// create a prepared statement
						String query = "delete from interruption where notificationId=?"; 
						PreparedStatement preparedStmt = con.prepareStatement(query); 
						// binding values
						preparedStmt.setInt(1, Integer.parseInt(notificationId)); 
						// execute the statement
						preparedStmt.execute(); 
						con.close(); 
						String newNotifications = readNotifications(); 
						 output = "{\"status\":\"success\",\"data\":\""+newNotifications+"\"}"; 

					} 
					
					catch (Exception e){ 
						output = "{\"status\":\"error\",\"data\":\"Error while deleting the Notification.\"}";
						System.err.println(e.getMessage()); 
					} 
					return output; 
			} 
			
			
			
			
} 
