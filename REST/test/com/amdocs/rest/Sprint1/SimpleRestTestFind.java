package com.amdocs.rest.Sprint1;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.amdocs.rest.init.HomePage;
import com.amdocs.rest.init.Request;
import com.amdocs.rest.init.Response;
import com.amdocs.rest.utils.Browser;

public class SimpleRestTestFind {

	static Logger logger = Logger.getLogger("SimpleRestTestFind");
	
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
	public void SimpleRestTestForGetMethod() {
	
//	logger.info("Executing SimpleRestTestGet test");
//		HomePage.goTo();
//		HomePage.verifyHomePagePresented("RESTClient");
//		Request.chooseMethod("GET");
//		Request.verifyMethodSelection("GET");
//		Request.addURL();
//		Request.submitRequest();
//		Response.verifySuccessResponse("200 OK");
//		Response.goToResponseBodyTab("Response Body (Preview)");
//		Response.collectResponseBodyTabData();
//	
//	logger.info("SimpleRestTestFind test is completed!");
//	System.out.println("Test is completed!");
	
	}
///////////////////////////new/////////////////////
	
}
