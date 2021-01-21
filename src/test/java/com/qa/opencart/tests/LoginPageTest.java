package com.qa.opencart.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.testlisteners.ExtentReportListener;
import com.qa.opencart.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

//@Listeners(ExtentReportListener.class)
//This test class will be html file for this class - listener At TEstNG class level

@Epic("Epic 100 :Feature Name : Lgin Page for Demo shop")
@Story("User story - 400 : design login page with different test case")
public class LoginPageTest extends BaseTest {
	
	private static final Logger LOGGER = Logger.getLogger(String.valueOf(LoginPageTest.class));

	@Test
	@Description(" Login Title test")
	@Severity(SeverityLevel.MINOR)
	public void loginPageTitleTest()
	{
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login Page Tile is : "+title);
		LOGGER.info("Login Page Tile is : "+title);
		Assert.assertEquals(title,Constants.LOGIN_PAGE_TITLE,"Page title not found");
	}
	@Description("check Forgot password linkt")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void forgotPwdLink()
	{
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	@Test
	@Description(" Login  test")
	@Severity(SeverityLevel.BLOCKER)
	public void loginTest()
	{
		accountsPage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		//accouny page display
		Assert.assertEquals(accountsPage.getAccountsPageTitle(), Constants.ACCOUNTS_PAGE_TITLE);
	}
}
