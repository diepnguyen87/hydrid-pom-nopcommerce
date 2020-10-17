package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.AdminDashboardPageUI;

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
		
		waitToElementInvisible(driver, AbstractPageUI.LOADING_ICON);
		
		return PageGeneratorManager.getAdminProductPage(driver);
	}
	
}
