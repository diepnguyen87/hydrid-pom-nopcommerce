package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.GetElementDisplayed;

import com.google.common.cache.LoadingCache;

import commons.AbstractPage;
import pageUIs.nopcommerce.NopcommerceAbstractPageUI;
import pageUIs.nopcommerce.AdminProductPageUI;

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

	public boolean areProductDetailDisplayed(String pictureName, String skuID, String price, String stockQuantity, String productType, String publishedStatus) {
		return isElementDisplay(driver, AdminProductPageUI.PRODUCT_DETAIL, pictureName, skuID, price, stockQuantity, productType, publishedStatus);
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

	public void openEditPageByProductName(String productName) {
		waitToElementClickable(driver, AdminProductPageUI.EDIT_BUTTON_BY_PRODUCT_NAME, productName);
		clickToElement(driver, AdminProductPageUI.EDIT_BUTTON_BY_PRODUCT_NAME, productName);
		waitToLoadingIconInvisible(driver);
	}

	public void inputToProductNameTextbox(String productName) {
		waitToElementVisible(driver, AdminProductPageUI.PRODUCT_NAME_TEXTBOX);
		sendkeyToElement(driver, AdminProductPageUI.PRODUCT_NAME_TEXTBOX, productName);
	}

	public void clickToSearchButton() {
		waitToElementVisible(driver, AdminProductPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminProductPageUI.SEARCH_BUTTON);
		waitToLoadingIconInvisible(driver);
	}

	public void scrollToPanelID(String panelID) {
		scrollToElement(driver, NopcommerceAbstractPageUI.PANEL_BY_ID, panelID);
	}

	public void inputToAltTextbox(String value) {
		waitToElementVisible(driver, AdminProductPageUI.ALT_TEXTBOX);
		sendkeyToElement(driver, AdminProductPageUI.ALT_TEXTBOX, value);
	}

	public void inputToTitleTextbox(String value) {
		waitToElementVisible(driver, AdminProductPageUI.TITLE_TEXTBOX);
		sendkeyToElement(driver, AdminProductPageUI.TITLE_TEXTBOX, value);
	}

	public String selectValueForOrderTextbox(String action) {
		waitToElementVisible(driver, AdminProductPageUI.INCREASE_DECREASE_ICON_FOR_ORDER, action);
		//sendkeyToElementByJS(driver, AdminProductPageUI.ORDER_TEXTBOX, value);
		clickToElement(driver, AdminProductPageUI.INCREASE_DECREASE_ICON_FOR_ORDER, action);
		return getElementAttribute(driver, AdminProductPageUI.ORDER_TEXTBOX, "aria-valuenow");
	}

	public void clickToAddProductPictureButton() {
		waitToElementClickable(driver, AdminProductPageUI.ADD_PRODUCT_PICTURE_BUTTON);
		clickToElement(driver, AdminProductPageUI.ADD_PRODUCT_PICTURE_BUTTON);
	}

	public boolean areProductInfoDisplayed(String pictureName, String orderNumber, String alt, String title) {
		return isElementDisplay(driver, NopcommerceAbstractPageUI.PICTURE_PANEL_DETAIL, pictureName, orderNumber, alt, title); 
	}

	public void clickToSaveButton() {
		waitToElementClickable(driver, AdminProductPageUI.SAVE_BUTTON);
		clickToElement(driver, AdminProductPageUI.SAVE_BUTTON);
		waitToLoadingIconInvisible(driver);
	}

	public void deletePictureByTitle(String pictureTitle) {
		waitToElementVisible(driver, AdminProductPageUI.DELETE_BUTTON_BY_PICTURE_TITLE, pictureTitle);
		clickToElement(driver, AdminProductPageUI.DELETE_BUTTON_BY_PICTURE_TITLE, pictureTitle);
		waitAlertPresence(driver);
		acceptAlert(driver);
		waitToLoadingIconInvisible(driver);
	}

	public void openPanelByID(String panelID) {
		String classAttribute = getElementAttribute(driver, NopcommerceAbstractPageUI.EXPANDED_ICON_BY_PANEL_ID, "class", panelID);
		if(classAttribute.contains("fa-plus")) {
			waitToElementClickable(driver, NopcommerceAbstractPageUI.PANEL_BY_ID, panelID);
			clickToElement(driver, NopcommerceAbstractPageUI.PANEL_BY_ID, panelID);
			sleepInMiliSecond(2);
		}
	}

	public boolean isPictureImageUploadedSuccessfully(String panelID) {
		waitToElementVisible(driver, AdminProductPageUI.QQ_UPLOAD_BUTTON_BY_PANEL_ID, panelID);
		return isElementDisplay(driver, AdminProductPageUI.QQ_UPLOAD_BUTTON_BY_PANEL_ID, panelID);
	}
	
}
