package com.qa.opencart.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {

	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String ACCOUNTS_PAGE_TITLE = "My Account";
	public static final String ACCOUNTS_PAGE_HEADER = "Your Store";
	public static final int ACCOUNTS_PAGE_SECTION_COUNT = 4;
	public static final String ACCOUNT_SUCCESS_MESSG="Your Account Has Been Created!";
	
	public static final String PHONES_PAGE_HEADER="Phones & PDAs";
	
	public static List<String> getAccntSectionsList()
	{
		List<String> accList = new ArrayList<>();
		   accList.add("My Account");
		   accList.add("My Orders");
		   accList.add("My Affiliate Account");
		   accList.add("Newsletter");
		   return accList;
		
	}
	public static List<String> getFooterLinkText()
	{
		List<String> footerLinkText = new ArrayList<>();
		footerLinkText.add("About Us");
		footerLinkText.add("Delivery Information");
		footerLinkText.add("Privacy Policy");
		footerLinkText.add("Terms & Conditions");
		footerLinkText.add("Contact Us");
		footerLinkText.add("Returns");
		footerLinkText.add("Site Map");
		footerLinkText.add("Brands");
		footerLinkText.add("Gift Certificates");
		footerLinkText.add("Affiliate");
		footerLinkText.add("Specials");
		footerLinkText.add("My Account");
		footerLinkText.add("Order History");
		footerLinkText.add("Wish List");
		footerLinkText.add("Newsletter");
		return footerLinkText;
		
	
	
	}
}
