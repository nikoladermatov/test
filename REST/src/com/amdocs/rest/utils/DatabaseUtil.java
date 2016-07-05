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
			
			
			public static void getHqGroupProductTrackingId() {
				Connection connection = conn();
				String query = "select * from HQ_GROUP_PRODUCTS order by tracking_id desc";	
				
				try {

					java.sql.Statement stmt = connection.createStatement();
					stmt.executeQuery(query);
					ResultSet rs = (ResultSet) stmt.executeQuery(query);
					System.out.println(rs);
					stmt.close();
					connection.close();

				} catch (SQLException e) {
					e.printStackTrace();
					throw new SkipException("Insert comment failed");
				}
	    }	
}
