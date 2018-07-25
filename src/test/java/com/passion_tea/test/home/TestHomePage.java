package com.passion_tea.test.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.passion_tea.common.UIUtils;
import com.passion_tea.pages.HomePage;
import com.passion_tea.pages.RegistrationPage;

@Listeners(com.passion_tea.testReport.Listener.class)

public class TestHomePage {

	public WebDriver driver;

	@BeforeClass
	public void getInitailDetails() {
		UIUtils.initialiseBrowser("chrome");
		driver = UIUtils.getDriver();
		UIUtils.implicitWait(driver);
		driver.get(UIUtils.getPropValue("BaseUrl"));
		UIUtils.implicitWait(driver);
	}

	@AfterClass
	public void tearDownMethod() {
		driver.close();
	}

	@Test
	public void VerifyApplicationPage() {
		HomePage.verifyHomePageDetails(driver);
	}

	@Test
	public void SignUpWebApplication() throws InterruptedException {
		Thread.sleep(1000);
		RegistrationPage.goToRegistrationPage(driver);
		Thread.sleep(1000);
		String MainWindow = driver.getWindowHandle();
		RegistrationPage RegistionObj = PageFactory.initElements(driver, RegistrationPage.class);
		String ChildWindow= RegistionObj.RegisterWebSite(driver);
		driver.switchTo().window(MainWindow);
		driver.close();
		driver.switchTo().window(ChildWindow);
		RegistrationPage.goToRegistrationPage(driver);
		
		Thread.sleep(5000);
	}
	
	
	@Test
	public void RegisterUserDetails() throws InterruptedException {
		RegistrationPage RegistionObj = PageFactory.initElements(driver, RegistrationPage.class);
		RegistionObj.fillUserDatails(driver);
	}

}
