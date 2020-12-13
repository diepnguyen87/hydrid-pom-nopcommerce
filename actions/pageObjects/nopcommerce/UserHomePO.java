package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;
import commons.AbstractPage;
import io.qameta.allure.Step;
import pageUIs.nopcommerce.UserHomePageUI;

public class UserHomePO extends AbstractPage{
	
	private WebDriver driver;
	
	public UserHomePO(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click to register link")
	public UserRegisterPO clickToRegisterLink() {
		waitToElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}

	public UserLoginPO clickToLoginLink() {
		waitToElementClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitToElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplay(driver, UserHomePageUI.MY_ACCOUNT_LINK);
	}

	public boolean isLogoutLinkDisplayed() {
		waitToElementVisible(driver, UserHomePageUI.LOGOUT_LINK);
		return isElementDisplay(driver, UserHomePageUI.LOGOUT_LINK);
	}

	public UserCustomerInfoPO clickToMyAccountLink() {
		waitToElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}

	@Step("Verify register link is display")
	public boolean isRegisterLinkDisplayed() {
		waitToElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		return isElementDisplay(driver, UserHomePageUI.REGISTER_LINK);
	}

	@Step("Verify login link is displayed")
	public boolean isLoginLinkDisplayed() {
		waitToElementClickable(driver, UserHomePageUI.LOGIN_LINK);
		return isElementDisplay(driver, UserHomePageUI.LOGIN_LINK);
	}

	public boolean isShoppingCartToolTipDisplayed() {
		waitToElementClickable(driver, UserHomePageUI.SHOPPING_CART_TOOLTIP);
		return isElementDisplay(driver, UserHomePageUI.SHOPPING_CART_TOOLTIP);
	}

	public boolean isRegisterLinkUndisplayed(){
		waitToElementInvisible(driver, UserHomePageUI.REGISTER_LINK);
		return isElementUndisplayed(driver, UserHomePageUI.REGISTER_LINK);
	}

	public boolean isLoginLinkUndisplayed() {
		waitToElementInvisible(driver, UserHomePageUI.LOGIN_LINK);
		return isElementUndisplayed(driver, UserHomePageUI.LOGIN_LINK);
	}

}
