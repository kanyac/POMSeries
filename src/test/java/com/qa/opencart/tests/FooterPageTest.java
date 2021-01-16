package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;


public class FooterPageTest extends BaseTest {
	@BeforeClass
	public void footerPageSetUp()
	{
		accountsPage= loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		footerPage = accountsPage.NavigateFooter();
	}
	
	
//	public Object[][] footerData(){
//		return new Object[][] {{"About Us"},
//				 {"Delivery Information"},
//				 {"Privacy Policy"},
//				 {"Terms & Conditions"},
//				 {"Contact Us"},
//				 {"Returns"},
//				 {"Site Map"},
//				 {"Brands"},
//				 {"Gift Certificates"},
//				 {"Affiliate"}, 
//				 {"Specials"}, 
//				 {"My Account"},
//				 {"Order History"}, 
//				 {"Wish List"}, 
//				 {"Newsletter"}};
//	}
	@Test
     public void checkFooterLinks()
     {
    	List<String> footList= footerPage.getFooterLinks();
    	//System.out.println(footList);
    	Assert.assertEquals(footList,Constants.getFooterLinkText());
     }
}
