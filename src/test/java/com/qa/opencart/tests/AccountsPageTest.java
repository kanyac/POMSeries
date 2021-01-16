package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
@Epic("Epic 200 :Feature name - Acoounts PAge ")
@Story("USer Story - 500 :Design  Acoounts PAge for appln with diff test cases")
public class AccountsPageTest extends BaseTest{
	@BeforeClass
	public void accountsPageSetUp()
	{
		accountsPage= loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		
	}

	@Test
	public void accountsPageTitleTest()
	{
		String title = accountsPage.getAccountsPageTitle();
		System.out.println("Title of accounts page : "+title);
		Assert.assertEquals(title, Constants.ACCOUNTS_PAGE_TITLE);
		
	}
	
	@Test
	public void verifyAccountsPageHeaderTest()
	{
		String header =accountsPage.getHeaderValue();
		System.out.println("Accounts Page Header is :"+header);
		Assert.assertEquals(header,Constants.ACCOUNTS_PAGE_HEADER);
	}
	
	@Test
	public void verifyAccountHeaderCount()
	{
		Assert.assertTrue(accountsPage.getAccountHeaderCount()== Constants.ACCOUNTS_PAGE_SECTION_COUNT);
	}
	
	@Test
	public void verifyAccountHeaderCountList()
	{
		List<String> accSecList =accountsPage.getAccountHeaderCountList();
		//System.out.println(accSecList);
		Assert.assertEquals(accSecList, Constants.getAccntSectionsList());
		//Assert later verify
	}
}
