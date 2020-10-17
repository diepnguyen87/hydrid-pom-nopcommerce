package pageObjects;

import org.openqa.selenium.WebDriver;
import commons.AbstractPage;
import pageUIs.AdminProductPageUI;

public class AdminProductPO extends AbstractPage{

	private WebDriver driver;
	
	public AdminProductPO(WebDriver driver) {
		this.driver = driver;
	}

	public void goToPageAtTableByIndex(String index) {
		waitToElementClickable(driver, AdminProductPageUI.PAGING_AT_TABLE_BY_INDEX, index);
		clickToElement(driver, AdminProductPageUI.PAGING_AT_TABLE_BY_INDEX, index);
	}

	public boolean isPageActivedAtTableByIndex(String activedIndex) {
		waitToElementVisible(driver, AdminProductPageUI.PAGING_AT_TABLE_ACTIVE_BY_INDEX, activedIndex);
		return isElementDisplay(driver, AdminProductPageUI.PAGING_AT_TABLE_ACTIVE_BY_INDEX, activedIndex);
	}

	public void checkToSelectAllCheckbox() {
		waitToElementClickable(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);
		checkToCheckbox(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);
	}

	public void uncheckToSelectAllCheckbox() {
		waitToElementClickable(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);
		unCheckToCheckbox(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);
	}

	public boolean areProductCheckboxChecked() {
		return areAllElementsSelected(driver, AdminProductPageUI.ALL_PRODUCT_CHECKBOX);
	}

	public void checkToProductCheckboxByName(String productName) {
		waitToElementClickable(driver, AdminProductPageUI.PRODUCT_CHECKBOX_BY_NAME, productName);
		checkToCheckbox(driver, AdminProductPageUI.PRODUCT_CHECKBOX_BY_NAME, productName);
	}

}
