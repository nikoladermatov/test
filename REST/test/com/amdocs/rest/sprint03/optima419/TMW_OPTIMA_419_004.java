package com.amdocs.rest.sprint03.optima419;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.amdocs.rest.init.HomePage;
import com.amdocs.rest.init.Request;
import com.amdocs.rest.init.Response;
import com.amdocs.rest.utils.Browser;

public class TMW_OPTIMA_419_004 {

	Logger logger = Logger.getLogger("TMW_OPTIMA_419_004");

	@Before
	public void setup() {
		Browser.init();
		Browser.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() {
		Browser.quitBrowser();
	}

	@Test
	public void Optima419_004() throws Exception {
	
		//test settings
		FileInputStream  configfile = new FileInputStream("properties/config.properties");
		Properties prop = new Properties();
		prop.load(configfile);
		
		//test execution
		logger.info("######################          Executing TMW_OPTIMA_419_004 test          ######################");
		
		HomePage.goTo();
		HomePage.verifyHomePagePresented("RESTClient");
		Request.chooseMethod("POST");
		Request.addContentTypeHeader("Content-Type","application/json");
		Request.addURL(prop.getProperty("TMW_OPTIMA_419_004_URL"));
		Request.addPayload(prop.getProperty("TMW_OPTIMA_419_004_Payload"));
		Request.submitRequest();
		Response.verifyResponseStatus("404 Not Found");
		Response.goToResponseBodyTab("Response Body (Preview)");
		Response.collectResponseBodyTabData();
	
		logger.info("######################          TMW_OPTIMA_419_004 test is completed!      ######################");
		
	}
	
	
}
