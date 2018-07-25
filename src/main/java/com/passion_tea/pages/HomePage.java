package com.passion_tea.pages;

import org.openqa.selenium.WebDriver;

import com.passion_tea.common.UIUtils;

public class HomePage {
	public static void verifyHomePageDetails(WebDriver driver) {
		Boolean pageTitle = UIUtils.ValidatePageTitle(driver,UIUtils.getPropValue("HomePageTitle"));
		System.out.println("Page Title Validate : "+pageTitle);
	}

	

}
