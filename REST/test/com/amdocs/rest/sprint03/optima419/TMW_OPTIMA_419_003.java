package com.amdocs.rest.sprint03.optima419;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.junit.Test;
import com.amdocs.rest.init.HomePage;
import com.amdocs.rest.init.Request;
import com.amdocs.rest.init.Response;
import com.amdocs.rest.utils.DatabaseUtil;

public class TMW_OPTIMA_419_003 {

	Logger logger = Logger.getLogger("TMW_OPTIMA_419_003");

	@Test
	public void Optima419_003() throws Exception {
	
		 //Test Property Reading Settings:
			FileInputStream  env = new FileInputStream("properties/env.properties");
			FileInputStream  services = new FileInputStream("properties/services.properties");
			FileInputStream  parameters = new FileInputStream("properties/parameters.properties");
			FileInputStream  config = new FileInputStream("properties/config.properties");
			Properties propenv = new Properties();
			Properties propservices = new Properties();
			Properties propparameters = new Properties();
			Properties propconfig = new Properties();
			propenv.load(env);
			propservices.load(services);
			propparameters.load(parameters);
			propconfig.load(config);
	
	    //Set Test Data:
		    int AccountInternalId = 135;
		
		//Test execution:
		logger.info("######################          Executing TMW_OPTIMA_419_003 test          ######################");
		
//		HomePage.goTo();
		HomePage.browserRefresh();
		HomePage.verifyHomePagePresented("RESTClient");
		Request.chooseMethod("POST");
		Request.addContentTypeHeader("Content-Type","application/json");
		Request.buildURL(
				//set environment ENDPOINT for the test
				propenv.getProperty("DEV") +
				//set required type ACCOUNT / SERVICE and accompanying Test Data
				propservices.getProperty("customeraccount") + AccountInternalId + 
				//set required SERVICE and accompanying Test Data
				propservices.getProperty("customerdeposits"));
		Request.addPayload(propconfig.getProperty("TMW_OPTIMA_419_003_Payload"));
		Request.submitRequest();
		//Validate Required Response Status
		Response.verifyResponseStatus("201 Created");
		Response.goToResponseBodyTab("Response Body (Preview)");
		DatabaseUtil.verifyDBrecord(propconfig.getProperty("sqlResult419"));
		DatabaseUtil.AssertDBrecord(propconfig.getProperty("sqlAssert419"));
		Response.collectResponseBodyTabData();
	
		logger.info("######################          TMW_OPTIMA_419_003 test is completed!      ######################");
	}
}
