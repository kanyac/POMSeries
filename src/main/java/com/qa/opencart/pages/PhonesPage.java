package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class PhonesPage {
	private WebDriver driver;
	private ElementUtil elementUtil;

	private By phoneHeader = By.xpath("//div[@id='content']/h2");
	public PhonesPage(WebDriver driver)
	{
		this.driver=driver;
		elementUtil =new ElementUtil(this.driver);
	}
	public String  getPhonePageHeader()
	{
		if(elementUtil.doIsDisplayed(phoneHeader))
		{
			return elementUtil.doGetText(phoneHeader);
		}
		return null;
		}
		

	

}
