package com.amdocs.rest.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.testng.SkipException;

public class DatabaseUtil {

	static ResultSet res;

			private static Connection conn() {
				// Load the JDBC driver
				String driverName = "oracle.jdbc.OracleDriver";
				Connection connection = null;
				try {
					Class.forName(driverName);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

				// Create a connection to the database
				Connection conn = null;
				String url = "jdbc:oracle:thin:@10.8.32.232:1521/CATFX30";
				String username = "fx40tc1t";
				String password = "arbor123";

				try {
					connection = DriverManager.getConnection(url, username, password);

				} catch (SQLException e) {
					e.printStackTrace();
				}

				return connection;
			}
			
			
			
			//Executes a query and returns a ResultSet
			

			public static String executeQuery(String query, String columnName) {
				Connection connection = conn();
				String result = null;
				ResultSet rs = null;
				try {

					java.sql.Statement stmt = connection.createStatement();
					rs = stmt.executeQuery(query);
					
					while (rs.next()) {
						return rs.getString(columnName);
					}

				} catch (SQLException e) {
					e.printStackTrace();
				} catch (NullPointerException e){
					return null;
				}finally {
					try {
						connection.close();
						rs.close();

					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				return result;
			}
			
			
			public static void getHqGroupProductTrackingId() throws SQLException {
						
					Connection connection = conn();
					
//					java.sql.Statement stmt = null;
				    String query = "select MAX(tracking_id)+3 from HQ_GROUP_PRODUCTS";

				    try {
				    	java.sql.Statement stmt = connection.createStatement();
				        ResultSet rs = stmt.executeQuery(query);
				        while (rs.next()) {
//				            String hqGroupProducts = rs.getString("HQ_GROUP_PRODUCTS");
				            int trackingId = rs.getInt("TRACKING_ID");
				            System.out.println(trackingId);
				        }}
					    catch (SQLException ex) {
					      System.out.println(ex);
					    }
					
						
//				   try {
//					   	  java.sql.Statement stmt = connection.createStatement();
//					      String query = "select MAX(tracking_id)+3 from HQ_GROUP_PRODUCTS";
//					      ResultSet result = (ResultSet) stmt.executeQuery(query);
//					      if (result.next()) {
//					        while (result.next()) {
//					          // Fetch value of "username" and "password" from "result"
//					          // object; this will return 2 existing users in the DB.
//
//					         
//					          String trackingId = result.getString("tracking_id");
//					          
//					          // print them on the console
//					          System.out.println(result);
//					          
//					        }
//					        result.close();
//					      }
//					    }
//
//					    catch (SQLException ex) {
//					      System.out.println(ex);
//					    }
				
//				String query = "select MAX(tracking_id)+3 from HQ_GROUP_PRODUCTS";	
//				
//				try {
//
//					java.sql.Statement stmt = connection.createStatement();
//					stmt.executeQuery(query);
//					ResultSet rs = (ResultSet) stmt.executeQuery(query);
//					System.out.println(rs);
//					stmt.close();
//					connection.close();
//					
//				} catch (SQLException e) {
//					e.printStackTrace();
//					throw new SkipException("Insert comment failed");
//				}
//	    }	
						
			}					
}
