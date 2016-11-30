package com.amdocs.rest.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;


public class Browser {

	public static WebDriver driver;
	
	private Browser(){
		
	}
	
	public static void initFF() {
		ProfilesIni profile = new ProfilesIni();		 
		FirefoxProfile myprofile = profile.getProfile("Niko");		 
		driver = new FirefoxDriver(myprofile);
	
	}
	
	public static void initGC() {
		
		System.setProperty("webdriver.chrome.driver", "C:/old_machine/Pragmatic/chromedriver_win32/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=C:/Users/nikolade/AppData/Local/Google/Chrome/User Data/");
		driver = new ChromeDriver(options);	
		
	}

	public static void quitBrowser() {
		driver.quit();
	}

}



