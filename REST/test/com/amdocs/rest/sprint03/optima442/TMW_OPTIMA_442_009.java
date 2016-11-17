package com.amdocs.rest.sprint03.optima442;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.junit.Test;
import com.amdocs.rest.init.HomePage;
import com.amdocs.rest.init.Request;
import com.amdocs.rest.init.Response;

public class TMW_OPTIMA_442_009 {

		Logger logger = Logger.getLogger("TMW_OPTIMA_442_009");

	@Test
	public void Optima442_009() throws Exception {
	
		//Test Property Reading Settings
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
		
		//set Test Data:
			int AccountInternalId = 135;
			String fromDate = "2015-06-01 00:00:00";
			String toDate = "2016-09-05 23:59:00";
		
		//Test purpose:
			//Verify requirement 84577, 84578
		
		//Expected Result: 
			//Status - 200 OK 		
				
		//Test execution
		logger.info("######################          Executing TMW_OPTIMA_442_009 test          ######################");
		
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
				//set EMBED parameter
				propparameters.getProperty("CreditUnitCr")
				);
		Request.submitRequest();
		//Validate Required Response Status
		Response.verifyResponseStatus("400 Bad Request");
		Response.goToResponseBodyTab("Response Body (Preview)");
		//Validate for message on exceeding maxdays parameter 
		Response.verifyTextPresence("Date range must not exceed configuration parameter maxdays 365.");
		Response.collectResponseBodyTabData();
				
		logger.info("######################          TMW_OPTIMA_442_009 test is completed!      ######################");
	}
}
