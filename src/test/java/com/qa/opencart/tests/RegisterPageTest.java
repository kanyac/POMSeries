package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class RegisterPageTest extends BaseTest {
	
	
	@BeforeClass
	public void registerPageSetup()
	{
		registerPage = loginPage.NavigateregisterPage();
		
	}
	@Test
	public void userRegistrationTest(String firstname,String lastname,String email,String phone,String password,String subscribe)
	{
		Assert.assertTrue(registerPage.accountRegister(firstname, lastname, email, phone, password, subscribe));
	}

}
