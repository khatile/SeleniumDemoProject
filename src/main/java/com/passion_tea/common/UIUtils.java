package com.passion_tea.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.passion_tea.constant.ProjectConstant;

public class UIUtils {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		UIUtils.driver = driver;
	}

	public static void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	}

	public static void initialiseBrowser(String browser) {
		if (("firefox").equals(browser)) {
			driver = new FirefoxDriver();
		} else if (("chrome").equals(browser)) {
			System.setProperty("webdriver.chrome.driver", "C:\\SOFTWARE\\EXE WEBDRIVER\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}

	}

	public static String getPropValue(String key) {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream(ProjectConstant.PROPERTIESFILEPATH);
			prop.load(input);
			return prop.getProperty(key);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;

	}

	public static void ClickButtonByXpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public static void ClickButtonById(String ButtonId) {
		driver.findElement(By.xpath(ButtonId)).click();
	}

	public static void ClickButtonByName(String ButtonName) {
		driver.findElement(By.xpath(ButtonName)).click();
	}

	public static boolean ValidatePageTitle(WebDriver driver, String propValue) {
		String PageTitle = driver.getTitle();
		System.out.println("Home Page Title : " + PageTitle);
		if (propValue.equals(PageTitle)) {
			return true;
		} else {
			return false;
		}

	}

	public static void ClickLinkByLinkName(WebDriver driver, String LinkName) {
		driver.findElement(By.linkText(LinkName));
		
	}

	public static String getPageTxtByClassName(WebDriver driver2, String string) {
		return	driver2.findElement(By.className(string)).getText();		
	}

	public static String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

}
