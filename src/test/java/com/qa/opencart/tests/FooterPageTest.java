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
	
	

	@Test
     public void checkFooterLinks()
     {
    	List<String> footList= footerPage.getFooterLinks();
    	System.out.println(footList);
    	Assert.assertEquals(footList,Constants.getFooterLinkHeadText());
     }
}
