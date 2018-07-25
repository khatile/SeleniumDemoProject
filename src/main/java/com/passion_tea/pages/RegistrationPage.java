package com.passion_tea.pages;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.passion_tea.common.UIUtils;

public class RegistrationPage {

	@FindBy(xpath = ".//*[@class='ajaxsubmit'][@id='load_form']/fieldset[1]/input" )
	public static	WebElement firstname;
	
	@FindBy(xpath = ".//*[@class='ajaxsubmit'][@id='load_form']/fieldset[2]/input" )
	static
	WebElement phonetxt;
	
	@FindBy(xpath = ".//*[@class='ajaxsubmit'][@id='load_form']/fieldset[3]/input" )
	static
	WebElement emailtxt;
	
	
	@FindBy(xpath = ".//*[@class='ajaxsubmit'][@id='load_form']/fieldset[5]/input" )
	static	WebElement Citytxt;
	
	
	@FindBy(xpath = ".//*[@class='ajaxsubmit'][@id='load_form']/fieldset[6]/input" )
	static	WebElement Username;
	
	@FindBy(xpath = ".//*[@class='ajaxsubmit'][@id='load_form']/fieldset[7]/input" )
	static	WebElement Passwordtxt;
	
	@FindBy(xpath = "//a[@class='link js-forgot-password']")
	WebElement lnkForgotPassword;
	
	@FindBy(xpath=".//*[@id=\"load_box\"]//*[@id='load_form']/div/div[2]/input[@class='button']")
	static WebElement SubmitBtn;
	
	public static void verifyRegistrationPage(WebDriver driver) {
		Boolean pageTitle = UIUtils.ValidatePageTitle(driver,UIUtils.getPropValue("RegistrationPageTitle"));
		System.out.println("Page Title Validate : "+pageTitle);
		String HeadingTxt = UIUtils.getPageTxtByClassName(driver,"heading");
		System.out.println(" Heading Txt : "+HeadingTxt);
	}

	public static void goToRegistrationPage(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath(".//*[@id='toggleNav']/li[6]/a")).click();;		
	}

	public static  String RegisterWebSite(WebDriver driver) throws InterruptedException {
		Set<String> s1=driver.getWindowHandles();		
	    Iterator<String> i1=s1.iterator();	
	    String ChildWindow = null;
	    while(i1.hasNext())			
	    {		
	        ChildWindow=i1.next();	
	        if(!driver.getWindowHandle().equalsIgnoreCase(ChildWindow))			
	        {
	        	driver.switchTo().window(ChildWindow);
	        	firstname.sendKeys(UIUtils.getSaltString());
	        	Username.sendKeys(UIUtils.getSaltString());
	        	Passwordtxt.sendKeys(UIUtils.getSaltString());
	        	phonetxt.sendKeys(UIUtils.getSaltString());
	        	Citytxt.sendKeys(UIUtils.getSaltString());
	        	
	        	emailtxt.sendKeys(UIUtils.getSaltString()+"@gmail.com");
	        	//driver.findElement(By.xpath("//*[@id=\\\"load_form\\\"]/div/div[2]/input")).click();
	        	System.out.println("****************************************");
	        	SubmitBtn.click();	
	        	System.out.println("##############################");
	   
	            
	        }		
	    }		
		
		return ChildWindow;
		
	}

	public static void fillUserDatails(WebDriver driver) throws InterruptedException {
		driver.findElement(By.name("name")).sendKeys(UIUtils.getSaltString());
		driver.findElement(By.xpath(".//*[@id='register_form']/fieldset[1]/p[2]/input")).sendKeys(UIUtils.getSaltString());
		driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[2]/div/label[1]/input")).click();
		driver.findElement(By.xpath("//*[@id='register_form']/fieldset[3]/div/label[2]/input")).click();
		Select Country = new Select(driver.findElement(By.xpath(".//*[@id='register_form']/fieldset[4]/select")));
		Country.selectByVisibleText("India");
		Select Month = new Select(driver.findElement(By.xpath(".//*[@id='register_form']/fieldset[5]/div[1]/select")));
		Month.selectByVisibleText("1");
		Select Day = new Select(driver.findElement(By.xpath(".//*[@id='register_form']/fieldset[5]/div[2]/select")));
		Day.selectByVisibleText("1");
		Select Year = new Select(driver.findElement(By.xpath(".//*[@id='register_form']/fieldset[5]/div[3]/select")));
		Year.selectByVisibleText("2014");		
		driver.findElement(By.xpath(".//*[@id='register_form']/fieldset[6]/input")).sendKeys(UIUtils.getSaltString());
		driver.findElement(By.xpath(".//*[@id='register_form']/fieldset[7]/input")).sendKeys(UIUtils.getSaltString());
		driver.findElement(By.xpath(".//*[@id='register_form']/fieldset[8]/input")).sendKeys(UIUtils.getSaltString()+"@gmail.com");
		driver.findElement(By.xpath(".//*[@id='register_form']/fieldset[10]/textarea")).sendKeys(UIUtils.getSaltString());
		driver.findElement(By.xpath(".//*[@id='register_form']/fieldset[11]/input")).sendKeys("sdfjhdfkkkkhdj");
		driver.findElement(By.xpath(".//*[@id='register_form']/fieldset[12]/input")).sendKeys("sdfjhdfkkkkhdj");
		driver.findElement(By.xpath(".//*[@id='register_form']/fieldset[13]/input")).submit();
		Thread.sleep(5000);
		
		
	}

}
