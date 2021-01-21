package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.AllComponentsPage;
import com.qa.opencart.pages.FooterPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.MonitorsPage;
import com.qa.opencart.pages.PhonesPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegisterPage;

public class BaseTest  {
	
	DriverFactory df;
	public Properties prop;
	WebDriver driver;
	
	public LoginPage loginPage;
	public AccountsPage accountsPage;
	public RegisterPage registerPage;
	public PhonesPage phonesPage;
	public MonitorsPage monitorsPage;
	public AllComponentsPage allComponentsPage;
	public FooterPage footerPage;
	public ProductInfoPage productInfoPage;
	@BeforeTest()
	public void setUp()
	{
		df= new DriverFactory(); //else pointing to null
		prop = df.init_prop(); //this prop is diff from driverfactory prop
	//	String browserName =prop.getProperty("browser");
		
		driver = df.init_driver(prop);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
	}
     @AfterTest()
     public void tearDown()
     {
    	 driver.quit();
     }
}
