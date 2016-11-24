package com.amdocs.rest.init;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;


import com.amdocs.rest.utils.Browser;

public class Request {

		static Logger logger = Logger.getLogger("Request");

		public static void addURL(String string) {
			// Add Previously created URL 
			
			Browser.driver.findElement(By.id("request-url")).sendKeys(string);
			logger.info("The request URL was successfully updated with " + string);
		}

		
		public static void buildURL(String string) {
			// Create the needed URL for the test
		
			Browser.driver.findElement(By.id("request-url")).click();
			Browser.driver.findElement(By.id("request-url")).sendKeys(string);
			logger.info("The request URL was successfully updated with " + string);
		}

		
		public static void submitRequest() {
			// Submit the request with all prerequisites
			
			Browser.driver.findElement(By.id("request-button")).click();
						
			if	(Browser.driver.findElement(By.cssSelector("div[class='progressBar']")).isDisplayed()) {
						
					do { Browser.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); 
					
					} while (Browser.driver.findElement(By.cssSelector("div[class='progressBar']")).isDisplayed());
						
			} else {
				
					logger.info("The request was successfully submitted.");								
			}
			logger.info("The request was successfully submitted.");
		}


		public static void chooseMethod(String string) {
			// Choose the Method for the test
			
			Browser.driver.findElement(By.id("request-method")).clear();
			Browser.driver.findElement(By.id("request-method")).sendKeys(string);
			logger.info("The request Method was successfully selected.");
		}


		public static void addPayload(String string) {
			// Add the payload to the request
			
			Browser.driver.findElement(By.id("request-body")).sendKeys(string);
			logger.info("The request Payload was successfully added.");	
		}


		public static void addContentTypeHeader(String string, String string2) {
			// Add request Header in case is needed 
			
			Browser.driver.findElement(By.xpath("//a[contains(text(),'Headers')]")).click();
			Browser.driver.findElement(By.xpath("//a[contains(text(),'Custom Header')]")).click();
			Browser.driver.findElement(By.name("name")).sendKeys(string);
			Browser.driver.findElement(By.name("value")).sendKeys(string2);
			Browser.driver.findElement(By.xpath("//input[contains(@onclick,'restclient.main.addCustomHeader();')]")).click();
			logger.info("ContentTypeHeader was successfully added.");
		}

}


