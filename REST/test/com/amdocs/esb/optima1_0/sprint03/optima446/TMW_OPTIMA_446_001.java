package com.amdocs.esb.optima1_0.sprint03.optima446;

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
public class TMW_OPTIMA_446_001 {

	Logger logger = Logger.getLogger("TMW_OPTIMA_446_001");

	@Before
	public void setup() {
		Browser.initFF();
		Browser.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}

	@Test
	public void Optima446_001() throws Exception {
	
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
			int AccountInternalId = 25;
		//Set Basic Summary Fields for validation
			String[] basicSummaryFields  = propconfig.get("bsf446").toString().split(",");
		//Set Embed Fields for validation
			String[] embedParameterFields  = propconfig.get("emb446").toString().split(",");
		
		//Test purpose:
			//
			//Verify requirement 84341
		
		//Expected Result: 
			//Success - 200 OK
		
		//Test execution
		logger.info("######################          Executing TMW_OPTIMA_446_001 test          ######################");
				
		HomePage.goTo();
		HomePage.verifyHomePagePresented("RESTClient");
		Request.chooseMethod("GET");
		Request.buildURL(
				//set environment ENDPOINT for the test
				propenv.getProperty("DEV") +
				//set required type ACCOUNT / SERVICE and accompanying Test Data
				propservices.getProperty("customeraccounts") + AccountInternalId + "?" +
				//set ADDITIONAL PARAMETERS section:
				//set EMBED parameter
				propparameters.getProperty("ServiceCenters")			
				);
		Request.submitRequest();
		//Validate Required Response Status
		Response.verifyResponseStatus("200 OK");
		Response.goToResponseBodyTab("Response Body (Preview)");
		//Validate Basic Summary Fields presence
		Response.verifyFieldPresence(basicSummaryFields);
		//Validate Embed Parameter presence
		Response.verifyTextPresence("serviceCenters");
		//Validate Embed Parameter Fields presence
		Response.verifyFieldPresence(embedParameterFields);
		Response.collectResponseBodyTabData();
				
		logger.info("######################          TMW_OPTIMA_446_001 test is completed!      ######################");
	}
}