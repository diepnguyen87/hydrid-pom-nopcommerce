package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.PageGeneratorManager;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.UserRegisterPO;

public class Level_12_Register_Login_Assert_Verify extends AbstractTest {

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
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		//Assert.assertTrue(homePage.isRegisterLinkDisplayed());
		//Assert.assertTrue(homePage.isLoginLinkDisplayed());
		verifyFalse(homePage.isRegisterLinkDisplayed());
		verifyTrue(homePage.isLoginLinkDisplayed());
		
		registerPage = homePage.clickToRegisterLink();

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

		registerPage.clickToRegisterLink();
		//Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed.");
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void TC_02_Login() {
		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();

		/*
		 * Assert.assertTrue(homePage.isMyAccountLinkDisplayed()); Assert.assertTrue(homePage.isLogoutLinkDisplayed());
		 * 
		 * Assert.assertTrue(homePage.isRegisterLinkUndisplayed()); Assert.assertTrue(homePage.isLoginLinkUndisplayed());
		 */
		
		verifyFalse(homePage.isMyAccountLinkDisplayed());
		verifyFalse(homePage.isLogoutLinkDisplayed());
		
		verifyTrue(homePage.isRegisterLinkUndisplayed());
		verifyFalse(homePage.isLoginLinkUndisplayed());
	}


	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
