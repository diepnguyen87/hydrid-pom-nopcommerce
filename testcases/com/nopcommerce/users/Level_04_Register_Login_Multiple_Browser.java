package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.AbstractTest;
import pageObjects.UserLoginPO;
import pageObjects.UserRegisterPO;
import pageObjects.UserCustomerInfoPO;
import pageObjects.UserHomePO;

public class Level_04_Register_Login_Multiple_Browser extends AbstractTest {

	private WebDriver driver;
	private String firstName, lastName, email, company, password, confirmPassword, day, month, year;

	private UserHomePO homePage;
	private UserLoginPO loginPage;
	private UserRegisterPO registerPage;
	private UserCustomerInfoPO customerInfoPage;

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
		homePage = new UserHomePO(driver);
		homePage.clickToRegisterLink();

		registerPage = new UserRegisterPO(driver);

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

		loginPage = new UserLoginPO(driver);
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

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
