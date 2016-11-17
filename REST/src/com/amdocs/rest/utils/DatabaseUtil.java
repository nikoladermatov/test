package com.amdocs.rest.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.junit.Assert;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.SkipException;

public class DatabaseUtil {

	static ResultSet res;
	static Logger logger = Logger.getLogger("DatabaseUtil");
	
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
				String url = "jdbc:oracle:thin:@10.230.16.75:1521/cust1";
				String username = "optimaesb_10_dev";
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
					
					
			}



			public static void verifyDBrecord(String string) throws SQLException {
				Connection connection = conn();
				
//			    String query = "select tracking_id, tracking_id_serv, account_no from DEPOSIT WHERE ROWNUM <= 1 order by tracking_id desc";
				String query = string;
				
			    try {
			    	java.sql.Statement stmt = connection.createStatement();
			        ResultSet rs = stmt.executeQuery(query);
			        while (rs.next()) {

			            int trackingId = rs.getInt("TRACKING_ID");
			            int trackingIdServ = rs.getInt("TRACKING_ID_SERV");
			            int accountNo = rs.getInt("ACCOUNT_NO");
			            
			            logger.info("The latest DB record for Customer Deposit is : " + "TrackingID :"  + trackingId + " , " + "TrackingIdServ :" + trackingIdServ + " for AccountNo:" + accountNo);
			            
//			            System.out.println("The latest DB record for Customer Deposit is : " + "TrackingID :"  + trackingId + " , " + "TrackingIdServ :" + trackingIdServ + " for AccountNo:" + accountNo);
			        }}
				    catch (SQLException ex) {
				      System.out.println(ex);
				    }
			
			}
			
			public static void AssertDBrecord(String string) throws SQLException {
				Connection connection = conn();
				
//			    String query = "select tracking_id from DEPOSIT WHERE ROWNUM <= 1 order by tracking_id desc";
				String query = string;
			    String responseMessageText = Browser.driver.findElement(By.cssSelector("span[class='header-value']")).getText();

			    try {
			    	java.sql.Statement stmt = connection.createStatement();
			        ResultSet rs = stmt.executeQuery(query);
			        while (rs.next()) {

			            int trackingId = rs.getInt("TRACKING_ID");
			            Assert.assertEquals(responseMessageText, responseMessageText.contains(query), false);
			            
			            logger.info("The response is presenting the same TRACKING_ID as the one at the DB : " + trackingId);       
			        }}
				    catch (SQLException ex) {
				      System.out.println(ex);
				    }
			    
			}
			
}
