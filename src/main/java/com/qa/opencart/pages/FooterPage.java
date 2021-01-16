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
	private By footer = By.xpath("//div[@class='col-sm-3']/ul[@class='list-unstyled']/li");
	
	public FooterPage(WebDriver driver)
	{
		this.driver=driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	public List<String> getFooterLinks()
	{
		List<WebElement> footerList= elementUtil.getElements(footer);
		List<String> footerInfo = new ArrayList<String>();
		for(int i=0;i<footerList.size();i++)
		{
			//System.out.println(footerList.get(i).getText());
			footerInfo.add(footerList.get(i).getText());
		}
			
		return footerInfo;
	}
}
