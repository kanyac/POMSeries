package com.qa.opencart.pages;

import org.openqa.selenium.By;

public class HomePage {
	
	
	private By Home = By.tagName("Your Store");
	public HomePage() {
	
	}
	public void goToHomePage()
	{
		System.out.println("Clicking on Home Page ");
	}
	
 
}
