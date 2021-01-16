package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class MonitorsPageTest extends BaseTest {
	
	@BeforeClass
	public void monitorsPageSetUp()
	{
		accountsPage= loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		monitorsPage = accountsPage.NavigateMonitorsPage();
	}
	
	@Test
	public void verifyMonitorPageHeader()
	{
		String text = monitorsPage.getMontitorPageHeader();
		
		Assert.assertEquals(text, "Monitors");
		System.out.println("Verifying header of Monitor PGE");
	}

}
