package com.amdocs.rest.init;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;

import com.amdocs.rest.utils.Browser;

public class Request {

		static Logger logger = Logger.getLogger("Request");

		public static void addURL() {
						
			Browser.driver.findElement(By.id("request-url")).sendKeys("http://10.230.21.49:8080/fx_rest/rest/HqGroupProducts?GroupId=8&GroupIdServ=1&TrackingId=2&TrackingIdServ=3");
//			System.out.println("URL is added.");
			logger.info("URL is added.");
		}


		public static void submitRequest() {
			
			Browser.driver.findElement(By.id("request-button")).click();
//			System.out.println("The request is executed.");
			logger.info("The request is executed.");
			
		}
}