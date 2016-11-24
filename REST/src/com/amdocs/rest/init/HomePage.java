package com.amdocs.rest.init;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import com.amdocs.rest.utils.Browser;

public class HomePage {

	static Logger logger = Logger.getLogger("HomePage");
    	
	public static void goTo() {
		// Add the default URL of the client
		
		Browser.driver.get("chrome://restclient/content/restclient.html");
		logger.info("Firefox browser instance was successfully initiated.");
	}

	
	public static void verifyHomePagePresented(String expectedValidationMessage) {
		// Verify that the loading of the Home page is completed
		
		if (Browser.driver.findElement(By.cssSelector("a[href='http://www.restclient.net/']")).isDisplayed()) {
			String actualValidationMessage = Browser.driver.findElement(By.cssSelector("a[href='http://www.restclient.net/']")).getText();
			Assert.assertEquals(expectedValidationMessage, actualValidationMessage);
			logger.info("Home Page is successfully presented.");
		} else {
			Browser.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);	
		}
		
	}

	
	public static void browserRefresh() {
		// Refresh the opened instance of Firefox browser
		
		Browser.driver.navigate().refresh();
	}
	
}

