package pageObjects;

import org.openqa.selenium.WebDriver;
import commons.AbstractPage;
import pageUIs.UserLoginPageUI;

public class UserLoginPO extends AbstractPage{

	private WebDriver driver;
	
	public UserLoginPO(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public UserHomePO clickToLoginButton() {
		waitToElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return new UserHomePO(driver);
	}

}
