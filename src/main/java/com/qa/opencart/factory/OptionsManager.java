package com.qa.opencart.factory;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	
	private static final Logger LOGGER = Logger.getLogger(String.valueOf(OptionsManager.class));
	private Properties prop;
	private FirefoxOptions fo;
	private ChromeOptions co;
	
	public OptionsManager(Properties prop)
	{
		this.prop = prop;
	}
 
	public ChromeOptions getChromeOptions()
	{
		LOGGER.info(" Setting up Chrome");
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
