package com.amdocs.rest.sprint03.optima442;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.junit.Test;
import com.amdocs.rest.init.HomePage;
import com.amdocs.rest.init.Request;
import com.amdocs.rest.init.Response;

public class TMW_OPTIMA_442_006 {

		Logger logger = Logger.getLogger("TMW_OPTIMA_442_006");

	@Test
	public void Optima442_006() throws Exception {
	
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
			String fromDate = "2016-07-01 00:00:00";
			String toDate = "2016-09-02 23:59:00";
			String Fields = "zip";
			int Maxcount = 2;
		//Set Basic Summary Fields for validation
			String[] basicSummaryFields  = propconfig.get("bsf442").toString().split(",");
		//Set Embed Fields for validation
			String[] embedParameterFields  = propconfig.get("emb442").toString().split(",");
		
		//Test purpose:
			//Verify requirement 84569, 84570, 84571, 84528, 84576
		
		//Expected Result: 
			//Status - 200 OK 		
				
		//Test execution
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
		//Validate Required Response Status
		Response.verifyResponseStatus("200 OK");
		Response.goToResponseBodyTab("Response Body (Preview)");
		//Validate Basic Summary Fields presence
		Response.verifyFieldPresence(basicSummaryFields);
		//Validate Embed Parameter presence
		Response.verifyTextPresence("creditUnitCr");
		//Validate Embed Parameter Fields presence
		Response.verifyFieldPresence(embedParameterFields);
		//Validate for message on more records found. 
		Response.verifyTextPresence("More records Found for the input criteria");
		//Validate for Additional Fields presence
		Response.verifyTextPresence("zip");
		Response.collectResponseBodyTabData();
				
		logger.info("######################          TMW_OPTIMA_442_006 test is completed!      ######################");
	}
}
