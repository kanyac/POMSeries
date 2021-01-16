package com.qa.opencart.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

public class PhonesPageTest extends BaseTest{
	
	@BeforeClass
	public void  phonesPageSetup()
	{	
		accountsPage= loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
//		phonesPage = accountsPage.NavigatePhonesPage();
	}
	@Test
	public void goToPhones()
	{
	 phonesPage = accountsPage.NavigatePhonesPage();
	}
	
	
	@Test
	public void verifyPhonesPageHeader()
	{
		String headerValue = phonesPage.getPhonePageHeader();
		Assert.assertEquals(headerValue, Constants.PHONES_PAGE_HEADER);
	}
}
