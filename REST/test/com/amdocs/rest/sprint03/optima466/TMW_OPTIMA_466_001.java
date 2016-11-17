package com.amdocs.rest.sprint03.optima466;
import java.net.HttpURLConnection;
import java.net.URL;
public class TMW_OPTIMA_466_001 {

	
	public static void main(String[] args) {
	try {

		URL url = new URL("http://10.230.16.71:8001/rest/v1/customeraccounts/135/customerbills/15201%2C0?embed=CreditUnitCr&maxcount=2");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

	} catch (Exception e) {
//
		e.printStackTrace();
	}
  }
}