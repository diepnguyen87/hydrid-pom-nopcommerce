package com.nopcommerce.users;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import commons.AbstractPage;

public class Level_02_Register_Login_AbstractPage_2 extends AbstractPage {

	private WebDriver driver;
	private String webURL = "https://demo.nopcommerce.com/";
	private String projectURL = System.getProperty("user.dir");
	private String firstName, lastName, email, company, password, confirmPassword;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectURL + "/browserDrivers/geckodriver.exe");
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		openPageUrl(driver, webURL);
		
		firstName = "Van";
		lastName = "Tran";
		email = firstName + "." + lastName + getRandomNumber() + "@gmail.com";
		company = "KITS";
		password = "123?Abcd";
		confirmPassword = "123?Abcd";
	}

	@Test
	public void TC_01_Register() {
		clickToElement(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//input[@id='gender-male']");
		
		sendkeyToElement(driver, "//input[@id='FirstName']", firstName);
		sendkeyToElement(driver, "//input[@id='LastName']", lastName);
		
		selectItemInDropdown(driver, "//select[@name='DateOfBirthDay']", "18");
		selectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']", "August");
		selectItemInDropdown(driver, "//select[@name='DateOfBirthYear']", "1958");
		
		sendkeyToElement(driver, "//input[@id='Email']", email);
		sendkeyToElement(driver, "//input[@id='Company']", company);
		sendkeyToElement(driver, "//input[@id='Password']", password);
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", confirmPassword);
	
		clickToElement(driver,  "//input[@id='register-button']");
		
		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");
		clickToElement(driver, "//a[@class='ico-logout']");
	}
	
	@Test
	public void TC_02_Login() {
		clickToElement(driver, "//a[@class='ico-login']");
		sendkeyToElement(driver, "//input[@id='Email']", email);
		sendkeyToElement(driver, "//input[@id='Password']", password);
		clickToElement(driver, "//input[@value ='Log in']");
		
		Assert.assertTrue(isElementDisplay(driver, "//a[@class='ico-account']"));
		Assert.assertTrue(isElementDisplay(driver, "//a[@class='ico-logout']"));
	}
	
	@Test
	public void TC_03_View_My_Account() {
		clickToElement(driver, "//a[@class='ico-account']");
		
		Assert.assertTrue(isElementSelected(driver, "//input[@id='gender-male']"));
	
		
		Assert.assertEquals(getElementAttribute(driver, "//input[@id='FirstName']", "value"), firstName);
		Assert.assertEquals(getElementAttribute(driver, "//input[@id='LastName']", "value"), lastName);
	
	
		Assert.assertEquals(getFirstSelectedTextInDropdown(driver, "//select[@name='DateOfBirthDay']"), "18");
		Assert.assertEquals(getFirstSelectedTextInDropdown(driver, "//select[@name='DateOfBirthMonth']"), "August");
		Assert.assertEquals(getFirstSelectedTextInDropdown(driver, "//select[@name='DateOfBirthYear']"), "1958");
	
	
		Assert.assertEquals(getElementAttribute(driver, "//input[@id='Email']", "value"), email);
		Assert.assertEquals(getElementAttribute(driver, "//input[@id='Company']", "value"), company);
		
	}
	
	private int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
