package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.AdminDashboardPO;
import pageObjects.AdminLoginPO;
import pageObjects.AdminProductPO;
import pageObjects.PageGeneratorManager;
import pageUIs.AdminProductPageUI;

public class Level_09_Web_Data_Table extends AbstractTest {

	private WebDriver driver;
	private String projectURL = System.getProperty("user.dir");
	
	private AdminLoginPO loginPage;
	private AdminDashboardPO dashboardPage;
	private AdminProductPO productPage;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String webURL) {
		
		driver = getBrowserDriver(browserName, webURL);
		loginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		dashboardPage = loginPage.loginToSystem("admin@yourstore.com", "admin");
		productPage = dashboardPage.openProductPage();
	}

	public void TC_01_Data_Table() {
		productPage.goToPageAtTableByIndex("2");
		Assert.assertTrue(productPage.isPageActivedAtTableByIndex("2"));
		
		productPage.goToPageAtTableByIndex("1");
		Assert.assertTrue(productPage.isPageActivedAtTableByIndex("1"));
		
		productPage.goToPageAtTableByIndex("3");
		Assert.assertTrue(productPage.isPageActivedAtTableByIndex("3"));
		
		productPage.goToPageAtTableByIndex("2");
		Assert.assertTrue(productPage.isPageActivedAtTableByIndex("2"));
	}
	
	@Test
	public void TC_02_Select_Deselect_All() {
		
		productPage.checkToSelectAllCheckbox();
		Assert.assertTrue(productPage.areProductCheckboxChecked());
		productPage.sleepInSecond(3);
		
		productPage.uncheckToSelectAllCheckbox();
		Assert.assertFalse(productPage.areProductCheckboxChecked());
		productPage.sleepInSecond(3);
		
		productPage.checkToProductCheckboxByName("$100 Physical Gift Card");
		productPage.sleepInSecond(3);
		productPage.checkToProductCheckboxByName("$100 Physical Gift Card");
		
		productPage.checkToProductCheckboxByName("adidas Consortium Campus 80s Running Shoes");
		productPage.sleepInSecond(3);
		
		productPage.checkToProductCheckboxByName("Apple MacBook Pro 13-inch");
		productPage.sleepInSecond(3);
		
	}
	
	@AfterClass
	public void afterClass() {
		//driver.close();
	}

}
