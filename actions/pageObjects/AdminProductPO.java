package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.GetElementDisplayed;

import com.google.common.cache.LoadingCache;

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
		waitToLoadingIconInvisible(driver);
	}

	public void uncheckToSelectAllCheckbox() {
		waitToElementClickable(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);
		unCheckToCheckbox(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);
	}

	public boolean areProductCheckboxChecked() {
		boolean result = areAllElementsSelected(driver, AdminProductPageUI.ALL_PRODUCT_CHECKBOX);
		waitToLoadingIconInvisible(driver);
		return result;
	}

	public void checkToProductCheckboxByName(String productName) {
		waitToElementClickable(driver, AdminProductPageUI.PRODUCT_CHECKBOX_BY_NAME, productName);
		checkToCheckbox(driver, AdminProductPageUI.PRODUCT_CHECKBOX_BY_NAME, productName);
		waitToLoadingIconInvisible(driver);
	}

	public boolean areProductDetailDisplayed(String productName, String skuID, String price, String stockQuantity, String productType, String publishStatus) {
		return isElementDisplay(driver, AdminProductPageUI.PRODUCT_DETAIL, productName, skuID, price, stockQuantity, productType, publishStatus);
	}

	public void selectShowItemsDropdown(String value) {
		waitToElementClickable(driver, AdminProductPageUI.SHOW_ITEMS_DROPDOWN);
		selectItemInDropdown(driver, AdminProductPageUI.SHOW_ITEMS_DROPDOWN, value);
	}

	public boolean isInformationDisplayedAtColumnNameAndRowNumber(String colunmName, String rowNumber, String expectedValue) {
		int columnNumber = getElements(driver, AdminProductPageUI.COLUMN_NAME_SIBLING, colunmName).size() + 1;
		String actualValue = getElementText(driver, AdminProductPageUI.CELL_DETAIL, rowNumber, String.valueOf(columnNumber));
		return actualValue.equals(expectedValue);
	}

	public boolean isPublishStatusAtColumnNameAndRowNumber(String colunmName, String rowNumber, String expectedValue) {
		int columnNumber = getElements(driver, AdminProductPageUI.COLUMN_NAME_SIBLING, colunmName).size() + 1;
		return isElementDisplay(driver, AdminProductPageUI.PUBLISH_STATUS_CELL, rowNumber, String.valueOf(columnNumber), expectedValue);
	}

	public void openEditPageByProductName(String string) {
		waitToElementClickable(driver, AdminProductPageUI.EDIT_BUTTON_BY_PRODUCT_NAME);
		clickToElement(driver, AdminProductPageUI.EDIT_BUTTON_BY_PRODUCT_NAME);
		waitToLoadingIconInvisible(driver);
	}

}
