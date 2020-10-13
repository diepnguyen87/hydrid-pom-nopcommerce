package com.nopcommerce.users;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;
import pageObjects.UserCustomerInfoPO;
import pageObjects.UserHomePO;

public class Level_03_Register_Login_Page_Object {

	private WebDriver driver;
	private String webURL = "https://demo.nopcommerce.com/";
	private String projectURL = System.getProperty("user.dir");
	private String firstName, lastName, email, company, password, confirmPassword, day, month, year;
	
	private UserHomePO homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private UserCustomerInfoPO customerInfoPage;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectURL + "/browserDrivers/geckodriver.exe");
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(webURL);
		
		firstName = "Van";
		lastName = "Tran";
		email = firstName + "." + lastName + getRandomNumber() + "@gmail.com";
		company = "KITS";
		password = "123?Abcd";
		confirmPassword = "123?Abcd";
		day = "18";
		month = "August";
		year = "1958";
	}

	@Test
	public void TC_01_Register() {
		homePage = new UserHomePO(driver);
		homePage.clickToRegisterLink();
		
		registerPage = new RegisterPageObject(driver);
		
		registerPage.clickToGenderMaleRadioButton();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		
		registerPage.selectDayDropdown("18");
		registerPage.selectMonthDropdown("August");
		registerPage.selectYearDropdown("1958");
		
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToCompanyTextbox(company);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);
	
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		registerPage.clickToLogoutLink();
		homePage = new UserHomePO(driver);
	}
	
	@Test
	public void TC_02_Login() {
		homePage.clickToLoginLink();
		
		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();

		homePage = new UserHomePO(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
	}
	
	@Test
	public void TC_03_View_My_Account() {
		homePage.clickToMyAccountLink();
		
		customerInfoPage = new UserCustomerInfoPO(driver);
		Assert.assertTrue(customerInfoPage.isGenderMaleRadioButtonSelected());
	
		
		Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), firstName);
		Assert.assertEquals(customerInfoPage.getLastNameTextboxvalue(), lastName);
	
		Assert.assertEquals(customerInfoPage.getSelectedTextInDayDropdown(), day);
		Assert.assertEquals(customerInfoPage.getSelectedTextInMonthDropdown(), month);
		Assert.assertEquals(customerInfoPage.getSelectedTextInYearDropdown(), year);
	
		Assert.assertEquals(customerInfoPage.getEmailTextboxValue(), email);
		Assert.assertEquals(customerInfoPage.getCompanyTextboxValue(), company);
		
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
