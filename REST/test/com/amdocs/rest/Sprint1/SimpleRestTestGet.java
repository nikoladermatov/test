package com.amdocs.rest.Sprint1;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.amdocs.rest.init.Response;
import com.amdocs.rest.init.Request;
import com.amdocs.rest.init.HomePage;
import com.amdocs.rest.utils.Browser;

	public class SimpleRestTestGet {
		
		static Logger logger = Logger.getLogger("SimpleRestTestGet");
		
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
	
			String url = "http://10.230.21.49:8080/fx_rest/rest/HqGroupProducts?GroupId=8&GroupIdServ=1&TrackingId=2&TrackingIdServ=3" ;
						
			logger.info("Executing SimpleRestTestGet test");
			
			HomePage.goTo();
			HomePage.verifyHomePagePresented("RESTClient");
			Request.chooseMethod("GET");
			Request.addURL(url);
			Request.submitRequest();
			Response.verifySuccessResponse("200 OK");
			Response.goToResponseBodyTab("Response Body (Preview)");
			Response.collectResponseBodyTabData();
		
			logger.info("SimpleRestTestGet test is completed!");
			
		}
}