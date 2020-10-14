package pageObjects;

import org.openqa.selenium.WebDriver;
import commons.AbstractPage;
import pageUIs.CustomerInfoPageUI;

public class UserCustomerInfoPO extends AbstractPage{

	private WebDriver driver;
	
	public UserCustomerInfoPO(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isGenderMaleRadioButtonSelected() {
		waitToElementVisible(driver, CustomerInfoPageUI.GENDER_MALE_RADIO);
		return isElementSelected(driver, CustomerInfoPageUI.GENDER_MALE_RADIO);
	}
	
	public String getFirstNameTextboxValue() {
		waitToElementVisible(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX, "value");
	}
	
	public String getLastNameTextboxvalue() {
		waitToElementVisible(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX, "value");
	}
	
	public String getSelectedTextInDayDropdown() {
		waitToElementVisible(driver, CustomerInfoPageUI.DAY_DROPDOWN);
		return getFirstSelectedTextInDropdown(driver, CustomerInfoPageUI.DAY_DROPDOWN);
	}
	
	public String getSelectedTextInMonthDropdown() {
		waitToElementVisible(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
		return getFirstSelectedTextInDropdown(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
	}
	
	public String getSelectedTextInYearDropdown() {
		waitToElementVisible(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
		return getFirstSelectedTextInDropdown(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
	}
	
	public String getEmailTextboxValue() {
		waitToElementClickable(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, "value");
	}
	
	public String getCompanyTextboxValue() {
		waitToElementClickable(driver, CustomerInfoPageUI.COMPANY_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.COMPANY_TEXTBOX, "value");
	}

}
