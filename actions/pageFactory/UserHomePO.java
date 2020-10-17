package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePO extends AbstractPage{
	
	private WebDriver driver;
	
	@FindBy(xpath = "//a[@class='ico-register']")
	private WebElement registerLink;
	
	@FindBy(xpath = "//a[@class='ico-login']")
	private WebElement loginLink;
	
	@FindBy(xpath = "//a[@class='ico-account']")
	private WebElement myAccountLink;
	
	@FindBy(xpath = "//a[@class='ico-logout']")
	private WebElement logoutLink;
	
	public UserHomePO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickToRegisterLink() {
		waitToElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);
	}

	public void clickToLoginLink() {
		waitToElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitToElementVisible(driver, myAccountLink);
		return isElementDisplay(driver, myAccountLink);
	}

	public boolean isLogoutLinkDisplayed() {
		waitToElementVisible(driver, logoutLink);
		return isElementDisplay(driver, logoutLink);
	}

	public void clickToMyAccountLink() {
		waitToElementClickable(driver, myAccountLink);
		clickToElement(driver, myAccountLink);
	}

}
