package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {
 
	private WebDriver driver;
	private ElementUtil elementUtil; 
	private By productNameHeader = By.xpath("//div[@class='col-sm-4']/h1");
	private By productMetaData = By.xpath("//div[@id='content']//ul[@class='list-unstyled'][position()=1]/li");
	private By price = By.xpath("//div[@id='content']//ul[@class='list-unstyled'][position()=2]/li");
	private By quantity = By.id("input-quantity");
	private By addToButton = By.id("button-cart");
	private By img = By.cssSelector("ul.thumbnails img");
	
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
		
	}
	
	public Map<String,String> getProductInformation()
	{
		 Map<String,String>productInfoMap = new HashMap<String,String>();
		 productInfoMap.put("name", elementUtil.doGetText(productNameHeader));
		 List<WebElement> productMetaDataList=elementUtil.getElements(productMetaData);
		
		// System.out.println(productMetaDataList.size());
		 for(WebElement e:productMetaDataList)
			{
			 
//			 Brand: Apple
//			 Product Code: Product 16
//			 Reward Points: 600
//			 Availability: Out Of Stock
			// System.out.println(e.getText());
			  String meta[]=e.getText().split(":");
			 
			  String metaName =meta[0].trim();//e.getText().split(":")[0].trim();
			  String metaValue = meta[1].trim();//e.getText().split(":")[1].trim();
			 // System.out.println(meta);
			//  System.out.println(metaName +"    ---- "+metaValue);
			  productInfoMap.put(metaName,metaValue);
			  
			}
		 List<WebElement> productPriceList = elementUtil.getElements(price);
		 productInfoMap.put("price", productPriceList.get(0).getText().trim());
		 productInfoMap.put("exTaxPrice",productPriceList.get(1).getText().split(":")[1].trim());
		// System.out.println(productInfoMap);
		 return productInfoMap;
	}
	
	public void selectQuantity(String qty) {
		elementUtil.doSendKeys(quantity, qty);
	}
	
	public void addToCart() {
		elementUtil.doClick(addToButton);
	}
	
	public int getProductImages() {
		int imageCount = elementUtil.getElements(img).size();
		System.out.println("total product images: " + imageCount);
		return imageCount;
	}
	
	public String getProductInfoPageTitle(String productName) {
		String title = elementUtil.waitForPageTitlePresent(productName, 5);
		System.out.println("Product Page title is : " + title);
		return title;
	}
}
