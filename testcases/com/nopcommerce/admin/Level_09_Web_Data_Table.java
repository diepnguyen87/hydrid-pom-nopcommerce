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

public class Level_09_Web_Data_Table extends AbstractTest {

	private WebDriver driver;
	private AdminLoginPO loginPage;
	private AdminDashboardPO dashboardPage;
	private AdminProductPO productPage;

	@Parameters({ "browser", "url" })
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

	// @Test
	public void TC_02_Select_Deselect_All() {

		productPage.checkToSelectAllCheckbox();
		Assert.assertTrue(productPage.areProductCheckboxChecked());

		productPage.uncheckToSelectAllCheckbox();
		Assert.assertFalse(productPage.areProductCheckboxChecked());

		productPage.checkToProductCheckboxByName("$100 Physical Gift Card");
		productPage.checkToProductCheckboxByName("$100 Physical Gift Card");

		productPage.checkToProductCheckboxByName("adidas Consortium Campus 80s Running Shoes");

		productPage.checkToProductCheckboxByName("Apple MacBook Pro 13-inch");
	}

	@Test
	public void TC_03_Display() {

		Assert.assertTrue(productPage.areProductDetailDisplayed("adidas Consortium Campus 80s Running Shoes", "AD_C80_RS", "27.56", "10000", "Simple", "true"));

		productPage.selectShowItemsDropdown("50");
		Assert.assertTrue(productPage.areProductDetailDisplayed("First Prize Pies", "FIRST_PRP", "51", "10000", "Simple", "false"));
		
	}
	
	@Test
	public void TC_04_Edit() {
		productPage.openEditPageByProductName("Apple iCam");
		productPage.backToPage(driver);
		
		productPage.openEditPageByProductName("Fahrenheit 451 by Ray Bradbury");
		productPage.backToPage(driver);
	
		productPage.openEditPageByProductName("adidas Consortium Campus 80s Running Shoes");
		productPage.backToPage(driver);
	
	}
	
	@Test
	public void TC_05_Position() {
		Assert.assertTrue(productPage.isInformationDisplayedAtColumnNameAndRowNumber("Product name", "2", "$25 Virtual Gift Card"));
		Assert.assertTrue(productPage.isInformationDisplayedAtColumnNameAndRowNumber("SKU", "2", "VG_CR_025"));
		Assert.assertTrue(productPage.isInformationDisplayedAtColumnNameAndRowNumber("Price", "2", "25"));
		Assert.assertTrue(productPage.isInformationDisplayedAtColumnNameAndRowNumber("Stock quantity", "2", ""));
		Assert.assertTrue(productPage.isInformationDisplayedAtColumnNameAndRowNumber("Product type", "2", "Simple"));
		Assert.assertTrue(productPage.isPublishStatusAtColumnNameAndRowNumber("Published", "15", "false"));

	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
