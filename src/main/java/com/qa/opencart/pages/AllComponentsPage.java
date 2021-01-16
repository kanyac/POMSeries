package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class AllComponentsPage {
	private WebDriver driver;
	private ElementUtil elementUtil;
	private By allcompPageHeader = By.xpath("//div[@id='content']/h2");
	
	public AllComponentsPage(WebDriver driver)
	{
		this.driver=driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	public String getAllComponentsPageHeader()
	{
		return elementUtil.doGetText(allcompPageHeader);
	}


}
