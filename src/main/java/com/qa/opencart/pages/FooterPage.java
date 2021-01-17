package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class FooterPage {

    private  WebDriver driver;
    private ElementUtil elementUtil;
	private By footer = By.xpath("//div[@class='container']//div[@class='col-sm-3']/ul[@class='list-unstyled']/li/a");
			
	private By footerHeader = By.xpath("//div[@id='content']/h1 | //div[@id='content']/h2");
	public FooterPage(WebDriver driver)
	{
		this.driver=driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	public List<String> getFooterLinks()
	{
		List<WebElement> footerList= elementUtil.waitforElementswithFluentWait(footer, 10,2);
		List<String> footerInfo = new ArrayList<String>();
		List<String> footHeaders = new ArrayList<String>();
		System.out.println(footerList.size());
		for(int i=0;i<footerList.size();i++)
		{
			footerInfo.add(footerList.get(i).getText());
			footerList.get(i).click();
			footerList= elementUtil.waitforElementswithFluentWait(footer, 10,2);
			String text= elementUtil.doGetText(footerHeader);
			footHeaders.add(text);
			
		}
			
		return footHeaders;
	}
}
