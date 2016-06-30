package com.amdocs.rest.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;


public class Browser {

	public static WebDriver driver;
	
	private Browser(){
		
	}
	
	public static void init() {
		ProfilesIni profile = new ProfilesIni();		 
		FirefoxProfile myprofile = profile.getProfile("Niko");		 
		driver = new FirefoxDriver(myprofile);

		
	}

	public static void quitBrowser() {
		driver.quit();
	}

}



