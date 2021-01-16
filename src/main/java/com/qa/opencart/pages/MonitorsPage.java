package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class MonitorsPage {
	private WebDriver driver;
	private ElementUtil elementUtil;
	private By monitorPageHeader = By.xpath("//div[@id='content']/h2");
	private By componentLink = By.xpath("//ul[@class='nav navbar-nav']/li[position()=3]/a"); 
	private By compAll = By.xpath("//ul[@class='nav navbar-nav']/li[position()=3]//div[@class='dropdown-menu']/a");
	public MonitorsPage(WebDriver driver)
	{
		this.driver=driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	public String getMontitorPageHeader()
	{
		return elementUtil.doGetText(monitorPageHeader);
	}
	public AllComponentsPage  NavigateAllComponentsPage()
	{
		elementUtil.clickWhenReady(componentLink, 5);
		elementUtil.doActionsClick(compAll);
		
				return new AllComponentsPage(driver);
			
	}

}
