package com.amdocs.rest.simpletests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.amdocs.rest.init.Body;
import com.amdocs.rest.init.HomePage;
import com.amdocs.rest.init.Request;
import com.amdocs.rest.init.Response;
import com.amdocs.rest.utils.Browser;
import com.amdocs.rest.utils.DatabaseUtil;

public class DBconnectionTest {

	
	static Logger logger = Logger.getLogger("SimpleRestTestCreate");
	
	@Before
	public void setup() {
		Browser.init();
		Browser.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

//	@After
//	public void tearDown() {
//		Browser.quitBrowser();
//	}

	@Test
	public void SimpleRestTestFindMethod() throws Exception {

		//test settings
		FileInputStream  configfile = new FileInputStream("properties/config.properties");
		Properties prop =new Properties();
		prop.load(configfile);	
		
		//test execution
		logger.info("Executing SimpleRestTestCreate test"); 
		
		HomePage.goTo();
		HomePage.verifyHomePagePresented("RESTClient");
		Request.chooseMethod("POST");
//		Request.addURL(prop.getProperty("HqGroupProductCreateUrl"));
		//Change the trackingId before execution, its a key field and should be unique.
//		DatabaseUtil.executeQuery(prop.getProperty("HqGroupProductCreateQuery"), prop.getProperty("HqGroupProductCreateQueryColumn"));
		DatabaseUtil.getHqGroupProductTrackingId();
//		Body.addPayload(prop.getProperty("HqGroupProductCreatePayload"));
//		Request.submitRequest();
//		Response.verifySuccessResponse("200 OK");
//		Response.goToResponseBodyTab("Response Body (Preview)");
//		Response.collectResponseBodyTabData();
//	
//		logger.info("SimpleRestTestCreate test is completed!");
		
	}
}
