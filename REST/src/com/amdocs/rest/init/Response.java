package com.amdocs.rest.init;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Appender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.DailyRollingFileAppender;
import org.junit.Assert;
import org.openqa.selenium.By;

import com.amdocs.rest.utils.Browser;

public class Response {
	
	static Logger logger = Logger.getLogger("Response");
	
	private static Date sysdate = new Date();
	private static SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMdd");
	
	public static void verifySuccessResponse(String expectedResponseMessage) {

		String actualResponseMessage = Browser.driver.findElement(By.cssSelector("span[class='header-value']")).getText();
		Assert.assertEquals(expectedResponseMessage, actualResponseMessage);
		String responseDetails = Browser.driver.findElement(By.cssSelector("ol[class='linenums']")).getText();
		logger.info("Response Details: " + responseDetails);
		
		System.out.println("Response Details: " + responseDetails);
		
		}


	public static void goToResponseBodyTab (String expectedResponseBodyTab) {
		Browser.driver.findElement(By.cssSelector("a[href='#response-body-preview']")).click();
		String actualResponseBodyTab = Browser.driver.findElement(By.cssSelector("a[href='#response-body-preview']")).getText();
		Assert.assertEquals(expectedResponseBodyTab, actualResponseBodyTab);
		logger.info(expectedResponseBodyTab + " tab is successfully selected");
		
		System.out.println(expectedResponseBodyTab + " tab is successfully selected");
	}


	public static void collectResponseBodyTabData() {
		String actualResponseBodyTabData = Browser.driver.findElement(By.cssSelector("div[class='pre']")).getText();
		logger.info("JSON Response Message:" + actualResponseBodyTabData);
		
		System.out.println("JSON Response Message:" + actualResponseBodyTabData);
	}

}
