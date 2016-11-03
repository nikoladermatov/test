package com.amdocs.rest.sprint03.optima442;

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
import com.amdocs.rest.utils.DatabaseUtil;

public class TMW_OPTIMA_442_006 {

		Logger logger = Logger.getLogger("TMW_OPTIMA_442_006");

//	@Before
//	public void setup() {
//		Browser.init();
//		Browser.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//	}
//
//	@After
//	public void tearDown() {
//		Browser.quitBrowser();
//	}

	@Test
	public void Optima442_006() throws Exception {
	
		//test settings
		FileInputStream  env = new FileInputStream("properties/env.properties");
		FileInputStream  services = new FileInputStream("properties/services.properties");
		FileInputStream  parameters = new FileInputStream("properties/parameters.properties");
		Properties propenv = new Properties();
		Properties propservices = new Properties();
		Properties propparameters = new Properties();
		propenv.load(env);
		propservices.load(services);
		propparameters.load(parameters);
		
		//set Test Data:
		int AccountInternalId = 135;
		String fromDate = "2016-07-01 00:00:00";
		String toDate = "2016-09-02 23:59:00";
		String Fields = "zip";
		int Maxcount = 2;
		
		//Test purpose:
		//Verify requirement 84569, 84570, 84571, 84528, 84576
		
		//Expected Result: 
		//Status - 200 OK 		
				
		//test execution
		logger.info("######################          Executing TMW_OPTIMA_442_006 test          ######################");
		
//		HomePage.goTo();
		HomePage.browserRefresh();
		HomePage.verifyHomePagePresented("RESTClient");
		Request.chooseMethod("GET");
		Request.buildURL(
				//set environment ENDPOINT for the test
				propenv.getProperty("DEV") +
				//set required type ACCOUNT / SERVICE and accompanying Test Data
				propservices.getProperty("customeraccount") + AccountInternalId + 
				//set required SERVICE and accompanying Test Data
				propservices.getProperty("customerbills") + "?" +
				//set ADDITIONAL PARAMETERS section:
				//set FILTER and  accompanying Test Data
				propparameters.getProperty("dateRangefilter") + fromDate + "^" + toDate + "&" +
				//set parameter 'N'and its value
				propparameters.getProperty("maxcount") + Maxcount + "&" +				
				//set EMBED parameter
				propparameters.getProperty("CreditUnitCr") + "&" +
				//set parameter 'FIELDS' and its value
				propparameters.getProperty("fields") + 	Fields
				);
		Request.submitRequest();
		Response.verifyResponseStatus("200 OK");
		Response.goToResponseBodyTab("Response Body (Preview)");
		Response.verify442BasicSummaryInformationPresence();
		Response.verifyTextPresence("creditUnitCr");
		Response.verifyTextPresence("More records Found for the input criteria");
		Response.verifyTextPresence("zip");
		Response.collectResponseBodyTabData();
				
		logger.info("######################          TMW_OPTIMA_442_006 test is completed!      ######################");
		
	}
	
}
