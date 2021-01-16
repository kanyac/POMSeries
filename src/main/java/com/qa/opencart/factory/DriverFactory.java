package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * 
 * @author K
 * 
 * 
 */
public class DriverFactory {

	WebDriver driver;
	Properties prop;
	OptionsManager optionsManager ;
	public static String highlight;
	
	
	public static ThreadLocal<WebDriver>tlDriver = new ThreadLocal<>();
	/**
	 * This method is used to intitalise the webdriver on the basis of browser name 
	 * @param browserName
	 * @return
	 */
	public WebDriver init_driver(Properties prop) {
		String browserName = prop.getProperty("browser");
		System.out.println("Browser name is : " + browserName);
		
		highlight = prop.getProperty("highlight").trim();//if not initialised null pointer exception
		optionsManager = new OptionsManager(prop);
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver(optionsManager.getChromeOptions());
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		}
		else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
		//	driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
		}
		else if(browserName.equals("safari")) {
			//driver = new SafariDriver();
			tlDriver.set(new SafariDriver());
		}
		else {
				System.out.println("Please pass the correct browser ..." + browserName);
			}
				
		//getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		
	//     return driver;	
		return getDriver();
	}
	
public static synchronized WebDriver getDriver()
{
	return tlDriver.get();
}
	/**
	 * This method is used to intialise the properties from config file 
	 * @return returns Properties prop
	 */
	public Properties init_prop() {
		
		 prop = new Properties();
		 try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 return prop;
		
	}
	
	public String getScreenshot()
	{
		File src = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE); //.OUPT instead of FILE if Img is broken
		String path= System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
		//String path = System.getProperty("user.dir")+ "/screenshots/"+System.currentTimeMillis()+".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
	
	
}
