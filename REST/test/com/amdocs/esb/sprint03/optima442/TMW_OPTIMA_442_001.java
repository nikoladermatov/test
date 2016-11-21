package com.amdocs.esb.sprint03.optima442;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import com.amdocs.rest.init.HomePage;
import com.amdocs.rest.init.Request;
import com.amdocs.rest.init.Response;
import com.amdocs.rest.utils.Browser;

public class TMW_OPTIMA_442_001 {

	Logger logger = Logger.getLogger("TMW_OPTIMA_442_001");

	@Before
	public void setup() {
		Browser.init();
		Browser.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}

	@Test
	public void Optima442_001() throws Exception {
	
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
			int Maxcount = 2;
		//Set Basic Summary Fields for validation
			String[] basicSummaryFields  = propconfig.get("bsf442").toString().split(",");
		//Set Embed Fields for validation
			String[] embedParameterFields  = propconfig.get("emb442").toString().split(",");
		
		//Test purpose:
			//Verify requirement 84525, 84526, 84570, 84528
		
		//Expected Result: 
			//Success - 200 OK
		
		//Test execution
		logger.info("######################          Executing TMW_OPTIMA_442_001 test          ######################");
				
		HomePage.goTo();
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
				propparameters.getProperty("CreditUnitCr") + "&" +
				//set parameter 'N'and its value
				propparameters.getProperty("maxcount") + Maxcount				
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
				
		logger.info("######################          TMW_OPTIMA_442_001 test is completed!      ######################");
	}
}
