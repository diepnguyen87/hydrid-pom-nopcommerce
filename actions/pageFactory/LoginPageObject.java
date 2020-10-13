package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends AbstractPage {

	private WebDriver driver;
	
	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTextBox;
	
	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordTextBox;
	
	@FindBy(xpath = "//input[@value ='Log in']")
	private WebElement loginButton;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, emailTextBox);
		sendkeyToElement(driver, emailTextBox, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisible(driver, passwordTextBox);
		sendkeyToElement(driver, passwordTextBox, password);
	}

	public void clickToLoginButton() {
		waitToElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
	}
}
