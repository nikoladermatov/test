package com.amdocs.rest.init;
import java.util.List;
import org.openqa.selenium.support.ui.Select;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.amdocs.rest.utils.Browser;

public class Request {

		static Logger logger = Logger.getLogger("Request");

		public static void addURL(String string) {
						
			Browser.driver.findElement(By.id("request-url")).sendKeys(string);
//			System.out.println("URL is added.");
			logger.info("URL is added.");
		}


		public static void submitRequest() {
			
			Browser.driver.findElement(By.id("request-button")).click();
//			System.out.println("The request is executed.");
			logger.info("The request is executed.");
			
		}


		public static void chooseMethod(String string) {
			Browser.driver.findElement(By.id("request-method")).clear();
			Browser.driver.findElement(By.id("request-method")).sendKeys(string);
//			System.out.println("The method was successfully selected.");
			logger.info("The method was successfully selected.");			
		}


}


