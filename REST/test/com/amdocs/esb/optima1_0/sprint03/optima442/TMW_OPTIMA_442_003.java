package com.amdocs.esb.optima1_0.sprint03.optima442;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.junit.Test;
import com.amdocs.rest.init.HomePage;
import com.amdocs.rest.init.Request;
import com.amdocs.rest.init.Response;

public class TMW_OPTIMA_442_003 {

	Logger logger = Logger.getLogger("TMW_OPTIMA_442_003");

	@Test
	public void Optima442_003() throws Exception {
	
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
		
		//Set Test Data:
			int AccountInternalId = 135;
			int BillRefNo = 15201;
			int BillRefResets = 0;
		//Set Basic Summary Fields for validation
			String[] basicSummaryFields  = propconfig.get("bsf442").toString().split(",");
		//Set Embed Fields for validation
			String[] embedParameterFields  = propconfig.get("emb442").toString().split(",");
		
		//Test purpose:
			//Verify requirement 84573
		
		//Expected Result: 
			//BL ignores maxcount parameter and returns success.
			//Status - 200 OK 
				
		//Test execution
		logger.info("######################          Executing TMW_OPTIMA_442_003 test          ######################");
				
//		HomePage.goTo();
		HomePage.browserRefresh();
		HomePage.verifyHomePagePresented("RESTClient");
		Request.chooseMethod("GET");
		Request.buildURL(
				//set environment ENDPOINT for the test
				propenv.getProperty("DEV") +
				//set required type ACCOUNT / SERVICE and accompanying Test Data
				propservices.getProperty("customeraccounts") + AccountInternalId + 
				//set required SERVICE and accompanying Test Data
				propservices.getProperty("customerbills_withCBiD") + BillRefNo + "%2C" + BillRefResets + "?" +
				//set ADDITIONAL PARAMETERS section:
				//set EMBED parameter
				propparameters.getProperty("CreditUnitCr")
				);
		Request.submitRequest();
		//Validate Required Response Status
		Response.verifyResponseStatus("200 OK");
		Response.goToResponseBodyTab("Response Body (Preview)");
		//Validate Basic Summary Fields presence
		Response.verifyFieldPresence(basicSummaryFields);
		//Validate Embed Parameter presence
		Response.verifyTextPresence("creditUnitCr");
		//Validate Embed Parameter Fields presence
		Response.verifyFieldPresence(embedParameterFields);
		Response.collectResponseBodyTabData();
				
		logger.info("######################          TMW_OPTIMA_442_003 test is completed!      ######################");
	}
}
