package com.nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import commons.AbstractTest;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.UserHomePO;
import pageObjects.nopcommerce.UserRegisterPO;

public class Common_01_Register extends AbstractTest {

	private WebDriver driver;
	private String firstName, lastName, company, confirmPassword, day, month, year;
	public static String email, password;
	
	private UserHomePO homePage;
	private UserRegisterPO registerPage;


	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) throws Exception {

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
		
		log.info("Register - Step 01: Open home page");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Register - Step 02: verify register link displayed");
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
		
		log.info("Register - Step 16: verify success message displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		log.info("Register - Step 17: click to logout link");
		homePage = registerPage.clickToLogoutLink();
		
		driver.close();
	}

}
