package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;


import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class AllComponetsPageTest extends BaseTest {

	@BeforeClass
	public void allComponentsPageSetUp()
	{
		accountsPage= loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		monitorsPage = accountsPage.NavigateMonitorsPage();
		allComponentsPage = monitorsPage.NavigateAllComponentsPage();
	}
	
	@Test
	public void verifyAllComponentsPageHeader()
	{
		String text = allComponentsPage.getAllComponentsPageHeader();
		Assert.assertEquals(text, "Components");
	}
	
}
