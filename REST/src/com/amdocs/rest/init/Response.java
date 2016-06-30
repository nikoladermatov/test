package com.amdocs.rest.init;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
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
//		System.out.println("Successful call , executed on: " + ft.format(sysdate));	
//		logger.info("Successful call , executed on: " + ft.format(sysdate));
		
		String responseDetails = Browser.driver.findElement(By.cssSelector("ol[class='linenums']")).getText();
//		System.out.println("Response Details:");
//		System.out.println(responseDetails);
		logger.info("Response Details: " + responseDetails);
		
		}


	public static void goToResponseBodyTab (String expectedResponseBodyTab) {
		Browser.driver.findElement(By.cssSelector("a[href='#response-body-preview']")).click();
		
		String actualResponseBodyTab = Browser.driver.findElement(By.cssSelector("a[href='#response-body-preview']")).getText();
		Assert.assertEquals(expectedResponseBodyTab, actualResponseBodyTab);
//		System.out.println(expectedResponseBodyTab + " tab is selected");
		logger.info(expectedResponseBodyTab + " tab is selected");
		
	}


	public static void collectResponseBodyTabData() {
		String actualResponseBodyTabData = Browser.driver.findElement(By.cssSelector("div[class='pre']")).getText();
//		System.out.println("JSON Response:");
//		System.out.println(actualResponseBodyTabData);
		logger.info("JSON Response Message:" + actualResponseBodyTabData);
		
	}

}
