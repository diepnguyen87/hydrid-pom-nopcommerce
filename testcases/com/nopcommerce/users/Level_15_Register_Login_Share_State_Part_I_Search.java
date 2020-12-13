package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nopcommerce.common.Common_01_Register;
import commons.AbstractTest;
import io.qameta.allure.Feature;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.UserHomePO;
import pageObjects.nopcommerce.UserLoginPO;

@Feature("User")
public class Level_15_Register_Login_Share_State_Part_I_Search extends AbstractTest {

	private WebDriver driver;
	private UserHomePO homePage;
	private UserLoginPO loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) throws Exception {

		driver = getBrowserDriver(browserName);
		
		log.info("Precondition - Step 01: click to login link");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		loginPage = homePage.clickToLoginLink();

		log.info("Precondition - Step 02: input to email text box with value: " + Common_01_Register.email);
		loginPage.inputToEmailTextbox(Common_01_Register.email);
		
		log.info("Precondition - Step 03: input to password text box with value: " + Common_01_Register.password);
		loginPage.inputToPasswordTextbox(Common_01_Register.password);
		
		log.info("Precondition - Step 04: click to login link");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Login - Step 05: verify my account link displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void TC_01_Search_Product_With_Name() {
		
	}
	
	@Test
	public void TC_02_Search_Product_With_Category() {
		
	}
	
	@Test
	public void TC_03_Search_Product_With_Sub_Category() {
		
	}
	
	@Test
	public void TC_04_Search_Product_With_Price() {
		
	}
	
	@Test
	public void TC_05_Search_Product_With_Manufacturer() {
		
	}
	

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
