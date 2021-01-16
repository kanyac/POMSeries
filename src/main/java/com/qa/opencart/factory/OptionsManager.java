package com.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	
	
	private Properties prop;
	private FirefoxOptions fo;
	private ChromeOptions co;
	
	public OptionsManager(Properties prop)
	{
		this.prop = prop;
	}
 
	public ChromeOptions getChromeOptions()
	{
		 co = new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) co.addArguments("--headless");
		if(Boolean.parseBoolean(prop.getProperty("incognito").trim())) co.addArguments("--incognito");
		return co;
	}
	
	public FirefoxOptions getFirefoxOptions()
	{
	    fo = new FirefoxOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) fo.addArguments("--headless");
		if(Boolean.getBoolean(prop.getProperty("incognito"))) fo.addArguments("--incognito");
		return fo;
	}
}
