package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.AbstractTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.UserHomePO;
import pageObjects.nopcommerce.UserLoginPO;
import pageObjects.nopcommerce.UserRegisterPO;

@Feature("User")
public class Level_17_Register_Login_Pattern_Object extends AbstractTest {

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
	public void TC_01_Validate_At_Register_Form() {
		log.info("Register - Step 01: Open home page");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Register - Step 02: Click to register link at home page");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register - Step 03: Click to register button");
		registerPage.clickToButtonByValue(driver, "Register");
		
		log.info("Register - Step 04: Verify error message display at firstName textbox");
		verifyEquals(registerPage.getErrorMessageAtMandantoryFieldByID(driver, "FirstName"), "First name is required.");
		
		log.info("Register - Step 05: Verify error message display at lastName textbox");
		verifyEquals(registerPage.getErrorMessageAtMandantoryFieldByID(driver, "LastName"), "Last name is required.");
		
		log.info("Register - Step 06: Verify error message display at email textbox");
		verifyEquals(registerPage.getErrorMessageAtMandantoryFieldByID(driver, "Email"), "Email is required.");
		
		log.info("Register - Step 07: Verify error message display at password textbox");
		verifyEquals(registerPage.getErrorMessageAtMandantoryFieldByID(driver, "Password"), "Password is required.");
		
		log.info("Register - Step 08: Verify error message display at confirmPassword textbox");
		verifyEquals(registerPage.getErrorMessageAtMandantoryFieldByID(driver, "ConfirmPassword"), "Password is required.");
		
		log.info("Register - Step 09: Verify error message display at confirmPassword textbox");
		verifyEquals(registerPage.getErrorMessageAtMandantoryFieldByID(driver, "ConfirmPassword"), "Email is required.");
		
	}
	
	@Test
	public void TC_02_Register_Success() {
		log.info("Register - Step 01: refresh to regiter page");
		registerPage.refreshCurrentpage(driver);

		log.info("Register - Step 02: Click to gender male radio button");
		registerPage.clickToRadioButtonByID(driver, "gender-male");
		
		log.info("Register - Step 03: input first name text box with value: " + firstName);
		registerPage.inputToTextboxByID(driver, "FirstName", firstName);
		
		log.info("Register - Step 04: input last name text box with value: " + lastName);
		registerPage.inputToTextboxByID(driver, "LastName", lastName);

		log.info("Register - Step 05: select day dropdown list");
		registerPage.selectDropdownByName(driver, "DateOfBirthDay", day);
		
		log.info("Register - Step 06: select month dropdown list");
		registerPage.selectDropdownByName(driver, "DateOfBirthMonth", month);
		
		log.info("Register - Step 07: select year dropdown list");
		registerPage.selectDropdownByName(driver, "DateOfBirthYear", year);

		log.info("Register - Step 08: input to email text box with value: " + email);
		registerPage.inputToTextboxByID(driver, "Email", email);
		
		log.info("Register - Step 09: input to company name text box with value: " + company);
		registerPage.inputToTextboxByID(driver, "Company", company);
		
		log.info("Register - Step 10: input to password text box with value: " + password);
		registerPage.inputToTextboxByID(driver, "Password", password);
		
		log.info("Register - Step 11: input to confirm password text box with value: " + confirmPassword);
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", password);

		log.info("Register - Step 12: click to register link");
		registerPage.clickToButtonByValue(driver, "Register");
		//Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		log.info("Register - Step 13: verify success message displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		log.info("Register - Step 14: click to logout link");
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void TC_03_Login_Success() {
		log.info("Login - Step 01: click to login link");
		loginPage = homePage.clickToLoginLink();

		log.info("Login - Step 02: input to email text box with value: " + email);
		loginPage.inputToTextboxByID(driver, "Email", email);
		
		log.info("Login - Step 03: input to password text box with value: " + password);
		loginPage.inputToTextboxByID(driver, "Password", password);
		
		log.info("Login - Step 04: click to login link");
		loginPage.clickToButtonByValue(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Login - Step 05: verify logout link display");
		verifyTrue(homePage.isLogoutLinkDisplayed());
		
		log.info("Login - Step 06: verify register link undisplayed");
		verifyTrue(homePage.isRegisterLinkUndisplayed());
		
		log.info("Login - Step 07: verify login link undisplayed");
		verifyTrue(homePage.isLoginLinkUndisplayed());
	}


	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
