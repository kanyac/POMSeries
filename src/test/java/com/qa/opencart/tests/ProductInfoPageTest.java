package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.base.BaseTest;

public class ProductInfoPageTest extends BaseTest {

	@BeforeClass
	public void accountsPageSetUp()
	{
		accountsPage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	@Test
	public void productInfoPageTitleTest_MacBook()
	{
		accountsPage.doSearch("MacBook");
		productInfoPage = accountsPage.selectProductFromResult("MacBook");
		Assert.assertEquals(productInfoPage.getProductInfoPageTitle("MacBook"), "MacBook");
	}
	
	@Test
	public void productInfoPageTitleTest_iMac()
	{
		accountsPage.doSearch("iMac");
		productInfoPage = accountsPage.selectProductFromResult("iMac");
		Assert.assertEquals(productInfoPage.getProductInfoPageTitle("iMac"), "iMac");
	}
	@Test
	public void verfiyProductImage() {
		String productName = "MacBook";
		accountsPage.doSearch(productName);
		productInfoPage= accountsPage.selectProductFromResult(productName);
		Assert.assertTrue(productInfoPage.getProductImages()==5);
		
	}
	@Test
	public void verifyProductInfoTest()
	{
		String productName="MacBook";
		accountsPage.doSearch(productName);
		productInfoPage= accountsPage.selectProductFromResult(productName);
		Map<String,String> productInfoMap=productInfoPage.getProductInformation();
		System.out.println(productInfoMap);
		productInfoMap.forEach((k,v)->System.out.println(k +" : "+v));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(productInfoMap.get("name"), productName);
		
		softAssert.assertEquals(productInfoMap.get("price"),"$500.00");
		softAssert.assertEquals(productInfoMap.get("Availability"), "Out Of Stock");
		softAssert.assertEquals(productInfoMap.get("Brand"), "Apple");
		softAssert.assertAll();
	}
	
	
	
	
}
