package pageObjects;

import org.openqa.selenium.WebDriver;
import commons.AbstractPage;
import pageUIs.HomePageUI;

public class UserHomePO extends AbstractPage{
	
	private WebDriver driver;
	
	public UserHomePO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterLink() {
		waitToElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
	}

	public void clickToLoginLink() {
		waitToElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitToElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplay(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

	public boolean isLogoutLinkDisplayed() {
		waitToElementVisible(driver, HomePageUI.LOGOUT_LINK);
		return isElementDisplay(driver, HomePageUI.LOGOUT_LINK);
	}

	public void clickToMyAccountLink() {
		waitToElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

}
