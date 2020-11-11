package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import io.qameta.allure.Step;
import pageUIs.UserRegisterPageUI;

public class UserRegisterPO extends AbstractPage{

	private WebDriver driver;
	
	public UserRegisterPO(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Click to gender male radio button")
	public void clickToGenderMaleRadioButton() {
		waitToElementClickable(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
		clickToElement(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
	}

	@Step("input to first name text box with value {0}")
	public void inputToFirstNameTextbox(String firstName) {
		waitToElementVisible(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

	@Step("Input to last name text box with value {0}")
	public void inputToLastNameTextbox(String lastName) {
		waitToElementVisible(driver, UserRegisterPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.LASTNAME_TEXTBOX, lastName);
	}

	public void selectDayDropdown(String day) {
		waitToElementClickable(driver, UserRegisterPageUI.DAY_DROPDOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.DAY_DROPDOWN, day);
	}

	public void selectMonthDropdown(String month) {
		waitToElementClickable(driver, UserRegisterPageUI.MONTH_DROPDOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.MONTH_DROPDOWN, month);		
	}

	public void selectYearDropdown(String year) {
		waitToElementClickable(driver, UserRegisterPageUI.YEAR_DROPDOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.YEAR_DROPDOWN, year);		
	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToCompanyTextbox(String company) {
		waitToElementVisible(driver, UserRegisterPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.COMPANY_TEXTBOX, company);
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitToElementVisible(driver, UserRegisterPageUI.CONFIRMPASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.CONFIRMPASSWORD_TEXTBOX, confirmPassword);
	}

	public void clickToRegisterLink() {
		waitToElementClickable(driver, UserRegisterPageUI.REGISTER_LINK);
		clickToElement(driver, UserRegisterPageUI.REGISTER_LINK);
	}

	public String getRegisterSuccessMessage() {
		waitToElementVisible(driver, UserRegisterPageUI.REGISTERED_SUCCESS_MSG);
		return getElementText(driver, UserRegisterPageUI.REGISTERED_SUCCESS_MSG);
	}

	public UserHomePO clickToLogoutLink() {
		waitToElementClickable(driver, UserRegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, UserRegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}

}
