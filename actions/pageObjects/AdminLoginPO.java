package pageObjects;

import org.openqa.selenium.WebDriver;
import commons.AbstractPage;
import pageUIs.LoginPageUI;

public class AdminLoginPO extends AbstractPage{

	private WebDriver driver;
	
	public AdminLoginPO(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public void clickToLoginButton() {
		waitToElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

}
