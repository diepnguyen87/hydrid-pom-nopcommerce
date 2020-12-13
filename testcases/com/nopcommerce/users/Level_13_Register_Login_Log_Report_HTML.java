package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.AbstractTest;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.UserHomePO;
import pageObjects.nopcommerce.UserLoginPO;
import pageObjects.nopcommerce.UserRegisterPO;

public class Level_13_Register_Login_Log_Report_HTML extends AbstractTest {

	private WebDriver driver;
	private String firstName, lastName, email, company, password, confirmPassword, day, month, year;

	private UserHomePO homePage;
	private UserLoginPO loginPage;
	private UserRegisterPO registerPage;


	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) throws Exception {

		driver = getBrowserDriver(browserName);

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
		log.info("Register - Step 01: Open home page");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Register - Step 01: verify register link displayed");
		verifyTrue(homePage.isRegisterLinkDisplayed());
		
		log.info("Register - Step 03: verify login link displayed");
		verifyTrue(homePage.isLoginLinkDisplayed());
		
		log.info("Register - Step 04: Click to register link at home page");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register - Step 05: Click to gender mal radio button");
		registerPage.clickToGenderMaleRadioButton();
		
		log.info("Register - Step 06: input first name text box with value: " + firstName);
		registerPage.inputToFirstNameTextbox(firstName);
		
		log.info("Register - Step 07: input last name text box with value: " + lastName);
		registerPage.inputToLastNameTextbox(lastName);

		log.info("Register - Step 08: select day dropdown list");
		registerPage.selectDayDropdown(day);
		
		log.info("Register - Step 09: select month dropdown list");
		registerPage.selectMonthDropdown(month);
		
		log.info("Register - Step 10: select year dropdown list");
		registerPage.selectYearDropdown(year);

		log.info("Register - Step 11: input to email text box with value: " + email);
		registerPage.inputToEmailTextbox(email);
		
		log.info("Register - Step 12: input to company name text box with value: " + company);
		registerPage.inputToCompanyTextbox(company);
		
		log.info("Register - Step 13: input to password text box with value: " + password);
		registerPage.inputToPasswordTextbox(password);
		
		log.info("Register - Step 14: input to confirm password text box with value: " + confirmPassword);
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);

		log.info("Register - Step 15: click to register link");
		registerPage.clickToRegisterLink();
		//Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		log.info("Register - Step 16: verify success message displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		log.info("Register - Step 17: click to logout link");
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void TC_02_Login() {
		log.info("Login - Step 01: click to login link");
		loginPage = homePage.clickToLoginLink();

		log.info("Login - Step 02: input to email text box with value: " + email);
		loginPage.inputToEmailTextbox(email);
		
		log.info("Login - Step 03: input to password text box with value: " + password);
		loginPage.inputToPasswordTextbox(password);
		
		log.info("Login - Step 04: click to login link");
		homePage = loginPage.clickToLoginButton();

		/*
		 * Assert.assertTrue(homePage.isMyAccountLinkDisplayed()); Assert.assertTrue(homePage.isLogoutLinkDisplayed());
		 * 
		 * Assert.assertTrue(homePage.isRegisterLinkUndisplayed()); Assert.assertTrue(homePage.isLoginLinkUndisplayed());
		 */
		
		log.info("Login - Step 05: verify my account link displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
		
		log.info("Login - Step 06: verify logout link display");
		verifyTrue(homePage.isLogoutLinkDisplayed());
		
		log.info("Login - Step 07: verify register link undisplayed");
		verifyTrue(homePage.isRegisterLinkUndisplayed());
		
		log.info("Login - Step 08: verify login link undisplayed");
		
		boolean result = homePage.isLoginLinkUndisplayed();
		System.out.println("check lai: " + result);
		verifyFalse(homePage.isLoginLinkUndisplayed());
	}


	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
