package com.amdocs.rest.init;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.amdocs.rest.utils.Browser;


public class Body {

	static Logger logger = Logger.getLogger("Body");
	
	public static void addPayload(String string) {
		Browser.driver.findElement(By.id("request-body")).sendKeys(string);
//		System.out.println("URL is added.");
		logger.info("Payload is added.");
		
	}


	
}
