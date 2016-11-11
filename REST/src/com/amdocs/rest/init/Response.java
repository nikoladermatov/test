package com.amdocs.rest.init;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import junit.framework.AssertionFailedError;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.commons.exec.ExecuteException;
import org.apache.log4j.Appender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.DailyRollingFileAppender;
import org.eclipse.jetty.util.component.LifeCycle.Listener;
import org.junit.Assert;
import org.omg.CORBA.portable.ApplicationException;
import org.omg.CORBA.portable.InputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;

import com.amdocs.rest.utils.Browser;
import com.sun.media.sound.InvalidFormatException;
import com.sun.rowset.internal.Row;
import com.thoughtworks.selenium.condition.Presence;


public class Response {
	
	static Logger logger = Logger.getLogger("Response");
	
	public static void verifyResponseStatus(String string) throws InterruptedException {
			// Verify the request response code returned against the one set at the test
		
			if (Browser.driver.findElement(By.id("response")).isDisplayed()) {
				
				String actualResponseMessage = Browser.driver.findElement(By.cssSelector("span[class='header-value']")).getText();
				Assert.assertEquals(string, actualResponseMessage);
				String responseDetails = Browser.driver.findElement(By.cssSelector("ol[class='linenums']")).getText();
				logger.info("Response Details: " + responseDetails);
				
			} else {
				Browser.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			}
		}	

	public static void goToResponseBodyTab (String expectedResponseBodyTab) {
			// Move the page to Response Body tab
		
			Browser.driver.findElement(By.cssSelector("a[href='#response-body-preview']")).click();
			String actualResponseBodyTab = Browser.driver.findElement(By.cssSelector("a[href='#response-body-preview']")).getText();
			Assert.assertEquals(expectedResponseBodyTab, actualResponseBodyTab);
			logger.info(expectedResponseBodyTab + " tab is successfully selected");
		}


	public static void collectResponseBodyTabData() {
			// Collect the all of the response data and add it to the log file
		
			String actualResponseBodyTabData = Browser.driver.findElement(By.cssSelector("div[class='pre']")).getText();
			logger.info("JSON Response Message:" + actualResponseBodyTabData);
		}


	public static void verifyTextPresence(String string) {		
			// Verify the existence of parameter, response message or etc, part of the response message
		
			try {
				// If the text is presented return the following
				Assert.assertTrue(Browser.driver.findElement(By.cssSelector("div[class='pre']")).getText().contains(string)); 			
				logger.info("Validation was done and " + "'" + string + "'" + " is successfully presented!");
	
				} catch (AssertionError e) {
					// If the text is NOT presented return the following and stop the test
					logger.info("Validation was done and " + "'" + string + "'" + " IS NOT presented!");
					logger.info("The test case has FAILED!");
					throw e;
				}	
    	} 


	public static void verifyBasicSummaryInformationPresence(String string) throws Exception  {
			// Verify the existence of all required Basic Summary Information fields

		   try {			     
					// If the text is presented continue with the next
					Assert.assertTrue(Browser.driver.findElement(By.cssSelector("div[class='pre']")).getText().contains(string));
					logger.info("'" + string + "'" + " field is presented at the Response!");
				
				} catch (AssertionError e) {
					// If the text is NOT presented return the following and stop the test
					logger.info("Basic Summary field : " + "'" + string + "'" + " IS MISSING FROM THE RESPOSE!");
					logger.info("The test case has FAILED!");
					throw e;
		}
			logger.info("All Basic Summary Information fields are presented at the Response!");
	}
			
	
	
	public static void verify442BasicSummaryInformationPresence()  {
		// Verify the existence of all required Basic Summary Information fields //
	
			String[] bsf442 = {"billRefNo","billRefResets","statementDate","paymentDueDate","fromDate","toDate","nextToDate"};
			for (String s: bsf442)
				
			try {
					// If the text is presented continue with the next
					Assert.assertTrue(Browser.driver.findElement(By.cssSelector("div[class='pre']")).getText().contains(s));
					logger.info("'" + s + "'" + " field is presented at the Response!");
				
				} catch (AssertionError e) {
					// If the text is NOT presented return the following and stop the test
					logger.info("Basic Summary field : " + "'" + s + "'" + " IS MISSING FROM THE RESPOSE!");
					logger.info("The test case has FAILED!");
					throw e;
		}
			logger.info("All Basic Summary Information fields are presented at the Response!");
	}
	
}