package com.nopcommerce.users;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nopcommerce.common.Common_02_Cookie;
import commons.AbstractTest;
import io.qameta.allure.Feature;
import pageObjects.PageGeneratorManager;
import pageObjects.UserHomePO;

@Feature("User")
public class Level_15_Register_Login_Share_State_Part_III_Cookie extends AbstractTest {

	private WebDriver driver;
	private UserHomePO homePage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) throws Exception {

		driver = getBrowserDriver(browserName);

		log.info("Login - Step 01: login by cookie");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		for(Cookie cookie : Common_02_Cookie.allCookies) {
			driver.manage().addCookie(cookie);
		}
		
		homePage.refreshCurrentpage(driver);
		
		log.info("Login - Step 02: verify my account link displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void TC_01_Sort_Name_Ascending() {
		
	}
	
	@Test
	public void TC_02_Sort_Name_Descending() {
		
	}
	
	@Test
	public void TC_03_Sort_Price_Ascending() {
		
	}
	
	@Test
	public void TC_04_Sort_Price_Descending() {
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
