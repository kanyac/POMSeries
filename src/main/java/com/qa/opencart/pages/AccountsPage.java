package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	//add footer list
	private WebDriver driver;
	private ElementUtil elementUtil;
	private By accountsHeaderCount= By.xpath("//div[@id='content']/h2");
	private By headerLogo =By.xpath("//div[@id='logo']//a");
	
	private By phonesLink = By.xpath("//ul[@class='nav navbar-nav']/li[position()=6]/a");
	
	private By componentLink = By.xpath("//ul[@class='nav navbar-nav']/li[position()=3]/a"); 
	private By componentList = By.xpath("//ul[@class='nav navbar-nav']/li[position()=3]/a/..//li/a");
	//private By compAll = By.xpath("//ul[@class='nav navbar-nav']/li[position()=3]//div[@class='dropdown-menu']/a");
	
	public AccountsPage(WebDriver driver) {
	
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	public String getAccountsPageTitle()
	{
		return elementUtil.waitForPageTitlePresent(Constants.ACCOUNTS_PAGE_TITLE, 5);
	}
	public int getAccountHeaderCount()
	{
		 return elementUtil.getElements(accountsHeaderCount).size();
	}
	public String getHeaderValue()
	{
		if (elementUtil.doIsDisplayed(headerLogo))
		{
			return elementUtil.doGetText(headerLogo);
		}
		return null;
	}
	public List<String> getAccountHeaderCountList()
	{
		  List<String>accountsList = new ArrayList<String>(); 
		  List<WebElement> accSectionList = elementUtil.getElements(accountsHeaderCount); 
		  for(WebElement e : accSectionList)
		  {
			  String section =e.getText();
			  accountsList.add(section);
			  
		  }
		  return accountsList;
	}
	public PhonesPage NavigatePhonesPage()
    {
    	elementUtil.clickWhenReady(phonesLink, 5);
    	System.out.println("Phone Link");
    	return new PhonesPage(driver);
    }
	public MonitorsPage  NavigateMonitorsPage()
	{
		elementUtil.clickWhenReady(componentLink, 5);
		List<WebElement> ele = elementUtil.getElements(componentList);
		System.out.println(ele.size());
		for(int i =0;i<ele.size();i++)
		{
			if(ele.get(i).getText().equals("Monitors (2)"))
			{
				ele.get(i).click();
				return new MonitorsPage(driver);	
			}	
		}
		return null;
			
	}
	public FooterPage NavigateFooter()
	{
		System.out.println("Moving to footer Links .............");
		return new FooterPage(driver);
	}
	

}
