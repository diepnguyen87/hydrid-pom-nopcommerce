package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.AbstractTest;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.UserCustomerAddressesPO;
import pageObjects.nopcommerce.UserCustomerInfoPO;
import pageObjects.nopcommerce.UserCustomerProductReviewsPO;
import pageObjects.nopcommerce.UserHomePO;
import pageObjects.nopcommerce.UserLoginPO;
import pageObjects.nopcommerce.UserOrdersHistoryPO;
import pageObjects.nopcommerce.UserRegisterPO;

public class Level_07_Register_Login_Switch_Page_Type extends AbstractTest {

	private WebDriver driver;
	private String firstName, lastName, email, company, password, confirmPassword, day, month, year;

	private UserHomePO homePage;
	private UserLoginPO loginPage;
	private UserRegisterPO registerPage;
	private UserCustomerInfoPO customerInfoPage;
	private UserCustomerAddressesPO addressesPage;
	private UserOrdersHistoryPO ordersHistoryPage;
	private UserCustomerProductReviewsPO myProductReviewsPage;
	
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
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void TC_02_Login() {
		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
	}

	@Test
	public void TC_03_View_My_Account() {
		customerInfoPage = homePage.clickToMyAccountLink();

		Assert.assertTrue(customerInfoPage.isGenderMaleRadioButtonSelected());

		Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), firstName);
		Assert.assertEquals(customerInfoPage.getLastNameTextboxvalue(), lastName);

		Assert.assertEquals(customerInfoPage.getSelectedTextInDayDropdown(), day);
		Assert.assertEquals(customerInfoPage.getSelectedTextInMonthDropdown(), month);
		Assert.assertEquals(customerInfoPage.getSelectedTextInYearDropdown(), year);

		Assert.assertEquals(customerInfoPage.getEmailTextboxValue(), email);
		Assert.assertEquals(customerInfoPage.getCompanyTextboxValue(), company);
	}
	
	@Test
	public void TC_04_Switch_Page() {
		addressesPage = customerInfoPage.openAddressesPage(driver);
		myProductReviewsPage = addressesPage.openMyProductReviewsPage(driver);
		ordersHistoryPage = myProductReviewsPage.openOrderPage(driver);
		addressesPage = ordersHistoryPage.openAddressesPage(driver);
		customerInfoPage = addressesPage.openCustomerInfoPage(driver);
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
