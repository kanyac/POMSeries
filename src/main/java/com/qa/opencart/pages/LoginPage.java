package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	//By locators  or Object Repositories 
	private By username = By.id("input-email") ;
	private By password = By.id("input-password");
	private By loginButton = By.cssSelector("input[value='Login']");
	private By forgotpwdLink = By.xpath("//div[@class='form-group']/a");
	
	private By registerLink = By.linkText("Register");
	
	
	//Constructor of Login Page
    public LoginPage(WebDriver driver)
    {
    	this.driver=driver;
    	elementUtil =new ElementUtil(this.driver);
    }
    
    //Page actions /methods
    @Step("get LOginpage title")
    public String getLoginPageTitle()
    {
    	//return driver.getTitle();
    	return elementUtil.waitForPageTitlePresent(Constants.LOGIN_PAGE_TITLE, 5);
    }
    
    public boolean isForgotPwdLinkExist()
    {
    	//return driver.findElement(forgotpwdLink).isDisplayed();
    	return elementUtil.doIsDisplayed(forgotpwdLink);
    	
    }
    public AccountsPage doLogin(String un,String pwd)
    {
    	System.out.println("Login  with "+un +" ,"+pwd);
    	elementUtil.doSendKeys(username, un);
    	elementUtil.doSendKeys(password, pwd);
    	elementUtil.doClick(loginButton);
//    	driver.findElement(username).sendKeys(un);
//    	driver.findElement(password).sendKeys(pwd);
//    	driver.findElement(loginButton).click();
    	return new AccountsPage(driver);
    	
    	//return page chaining
    }
    public RegisterPage NavigateregisterPage()
    {
    	elementUtil.doClick(registerLink);
    	System.out.println("NAvigate to register page");
    	return new RegisterPage(driver);
    }
    
}
