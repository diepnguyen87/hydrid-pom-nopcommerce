package com.nopcommerce.users;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import commons.AbstractPage;

public class Level_02_Register_Login_AbstractPage_1 {

	private WebDriver driver;
	private String webURL = "https://demo.nopcommerce.com/";
	private String projectURL = System.getProperty("user.dir");
	private String firstName, lastName, email, company, password, confirmPassword;
	private Select select;
	private AbstractPage abstractPage;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectURL + "/browserDrivers/geckodriver.exe");
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		abstractPage = new AbstractPage();
		abstractPage.openPageUrl(driver, webURL);
		
		firstName = "Van";
		lastName = "Tran";
		email = firstName + "." + lastName + getRandomNumber() + "@gmail.com";
		company = "KITS";
		password = "123?Abcd";
		confirmPassword = "123?Abcd";
	}

	@Test
	public void TC_01_Register() {
		abstractPage.clickToElement(driver, "//a[@class='ico-register']");
		abstractPage.clickToElement(driver, "//input[@id='gender-male']");
		
		abstractPage.sendkeyToElement(driver, "//input[@id='FirstName']", firstName);
		abstractPage.sendkeyToElement(driver, "//input[@id='LastName']", lastName);
		
		abstractPage.selectItemInDropdown(driver, "//select[@name='DateOfBirthDay']", "18");
		abstractPage.selectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']", "August");
		abstractPage.selectItemInDropdown(driver, "//select[@name='DateOfBirthYear']", "1958");
		
		abstractPage.sendkeyToElement(driver, "//input[@id='Email']", email);
		abstractPage.sendkeyToElement(driver, "//input[@id='Company']", company);
		abstractPage.sendkeyToElement(driver, "//input[@id='Password']", password);
		abstractPage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", confirmPassword);
	
		abstractPage.clickToElement(driver,  "//input[@id='register-button']");
		
		Assert.assertEquals(abstractPage.getElementText(driver, "//div[@class='result']"), "Your registration completed");
		abstractPage.clickToElement(driver, "//a[@class='ico-logout']");
	}
	
	@Test
	public void TC_02_Login() {
		abstractPage.clickToElement(driver, "//a[@class='ico-login']");
		abstractPage.sendkeyToElement(driver, "//input[@id='Email']", email);
		abstractPage.sendkeyToElement(driver, "//input[@id='Password']", password);
		abstractPage.clickToElement(driver, "//input[@value ='Log in']");
		
		Assert.assertTrue(abstractPage.isElementDisplay(driver, "//a[@class='ico-account']"));
		Assert.assertTrue(abstractPage.isElementDisplay(driver, "//a[@class='ico-logout']"));
	}
	
	@Test
	public void TC_03_View_My_Account() {
		abstractPage.clickToElement(driver, "//a[@class='ico-account']");
		
		Assert.assertTrue(abstractPage.isElementSelected(driver, "//input[@id='gender-male']"));
	
		
		Assert.assertEquals(abstractPage.getElementAttribute(driver, "//input[@id='FirstName']", "value"), firstName);
		Assert.assertEquals(abstractPage.getElementAttribute(driver, "//input[@id='LastName']", "value"), lastName);
	
	
		Assert.assertEquals(abstractPage.getFirstSelectedTextInDropdown(driver, "//select[@name='DateOfBirthDay']"), "18");
		Assert.assertEquals(abstractPage.getFirstSelectedTextInDropdown(driver, "//select[@name='DateOfBirthMonth']"), "August");
		Assert.assertEquals(abstractPage.getFirstSelectedTextInDropdown(driver, "//select[@name='DateOfBirthYear']"), "1958");
	
	
		Assert.assertEquals(abstractPage.getElementAttribute(driver, "//input[@id='Email']", "value"), email);
		Assert.assertEquals(abstractPage.getElementAttribute(driver, "//input[@id='Company']", "value"), company);
		
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
