package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;
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

public class Level_10_Upload_File extends AbstractTest {

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

	@Test
	public void TC_01_Upload_File() {

		// old data
		String productName = "Adobe Photoshop CS4";
		String pictureName = productName.toLowerCase();
		pictureName = pictureName.replaceAll("\s", "-");
		String skuID = "AD_CS4_PH";
		String price = "75";
		String stockQuantity = "10000";
		String productType = "Simple";
		String publishedStatus = "true";
		String panelID = "product-pictures";

		// new data
		String alt = "Alt 1";
		String title = "Title 1";

		// search product 'Adobe Photoshop CS4'
		productPage.inputToProductNameTextbox(productName);
		productPage.clickToSearchButton();

		// go to edit page
		productPage.openEditPageByProductName(productName);

		// scroll to picture panel
		productPage.scrollToPanelID(panelID);

		//open pciture panel
		productPage.openPanelByID(panelID);
		
		// handle upload image
		productPage.uploadFileByPanelID(driver, panelID, "photoshop_ps6.jpg");
		Assert.assertTrue(productPage.isPictureImageUploadedSuccessfully(panelID));
		productPage.sleepInSecond(3);

		productPage.inputToAltTextbox(alt);
		productPage.inputToTitleTextbox(title);
		//String order = productPage.getValueByColumnAndRow(driver, panelID, "Display order", "1") - 1 + "";
		String order = productPage.selectValueForOrderTextbox("Increase");

		// add product picture
		productPage.clickToAddProductPictureButton();

		// verify on picture panel
		Assert.assertTrue(productPage.areProductInfoDisplayed(pictureName, order, alt, title));

		// save edit page and back to product page
		productPage.clickToSaveButton();

		// search product 'Adobe Photoshop CS4'
		productPage.inputToProductNameTextbox(productName);
		productPage.clickToSearchButton();

		// verify on product page -> found
		Assert.assertTrue(productPage.areProductDetailDisplayed(pictureName, skuID, price, stockQuantity, productType, publishedStatus));

		// go to edit page
		productPage.openEditPageByProductName(productName);

		// scroll to picture panel
		productPage.scrollToPanelID(panelID);

		// delete picture
		productPage.deletePictureByTitle(title);

		// save edit page and back to product page
		productPage.clickToSaveButton();

		// search product 'Adobe Photoshop CS4'
		productPage.inputToProductNameTextbox(productName);
		productPage.clickToSearchButton();

		// verify on product page -> not found
		Assert.assertTrue(productPage.areProductDetailDisplayed("default-image_75", skuID, price, stockQuantity, productType, publishedStatus));

	}

	@AfterClass
	public void afterClass() {
		// driver.close();
	}

}
