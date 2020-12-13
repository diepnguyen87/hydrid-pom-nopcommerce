package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopcommerce.AbstractPageUI;
import pageUIs.nopcommerce.AdminDashboardPageUI;

public class AdminDashboardPO extends AbstractPage{

	private WebDriver driver;
	
	public AdminDashboardPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminProductPO openProductPage() {
		waitToElementClickable(driver, AdminDashboardPageUI.CATALOG_LINK_AT_SIDEBAR);
		clickToElement(driver, AdminDashboardPageUI.CATALOG_LINK_AT_SIDEBAR);
		
		waitToElementClickable(driver, AdminDashboardPageUI.PRODUCT_LINK_AT_SIDEBAR);
		clickToElement(driver, AdminDashboardPageUI.PRODUCT_LINK_AT_SIDEBAR);
		
		waitToLoadingIconInvisible(driver);
		
		return PageGeneratorManager.getAdminProductPage(driver);
	}
	
}
