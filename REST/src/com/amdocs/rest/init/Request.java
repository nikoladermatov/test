package com.amdocs.rest.init;
import java.util.List;

import org.openqa.selenium.support.ui.Select;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Appender;
import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.DailyRollingFileAppender;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.amdocs.rest.utils.Browser;

public class Request {

		static Logger logger = Logger.getLogger("Request");

		public static void addURL(String string) {
						
			Browser.driver.findElement(By.id("request-url")).sendKeys(string);
			logger.info("URL was successfully added.");
			
			System.out.println("URL was successfully added.");
		}


		public static void submitRequest() {
			
			Browser.driver.findElement(By.id("request-button")).click();
			logger.info("The request was successfully submitted.");

			System.out.println("The request was successfully submitted.");
		}


		public static void chooseMethod(String string) {
			Browser.driver.findElement(By.id("request-method")).clear();
			Browser.driver.findElement(By.id("request-method")).sendKeys(string);
			logger.info("The method was successfully selected.");
			
			System.out.println("The method was successfully selected.");
		}


}


