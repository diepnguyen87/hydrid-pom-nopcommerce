package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;
import commons.AbstractPage;
import pageUIs.orangehrm.LoginPageUI;

public class LoginPO extends AbstractPage{

	private WebDriver driver;
	
	public LoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToUsernameTextbox(String userName) {
		waitToElementVisible(driver, LoginPageUI.USER_NAME_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.USER_NAME_TEXTBOX, userName);
	}

	public void enterToPasswordTextbox(String password) {
		waitToElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public DashboardPO clickToLoginButton() {
		waitToElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getDashboardPage(driver);
	}

}
