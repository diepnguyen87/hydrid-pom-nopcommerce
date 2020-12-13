package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;
import commons.AbstractPage;
import pageUIs.nopcommerce.UserCustomerInfoPageUI;

public class UserCustomerInfoPO extends AbstractPage{

	private WebDriver driver;
	
	public UserCustomerInfoPO(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isGenderMaleRadioButtonSelected() {
		waitToElementVisible(driver, UserCustomerInfoPageUI.GENDER_MALE_RADIO);
		return isElementSelected(driver, UserCustomerInfoPageUI.GENDER_MALE_RADIO);
	}
	
	public String getFirstNameTextboxValue() {
		waitToElementVisible(driver, UserCustomerInfoPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.FIRSTNAME_TEXTBOX, "value");
	}
	
	public String getLastNameTextboxvalue() {
		waitToElementVisible(driver, UserCustomerInfoPageUI.LASTNAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.LASTNAME_TEXTBOX, "value");
	}
	
	public String getSelectedTextInDayDropdown() {
		waitToElementVisible(driver, UserCustomerInfoPageUI.DAY_DROPDOWN);
		return getFirstSelectedTextInDropdown(driver, UserCustomerInfoPageUI.DAY_DROPDOWN);
	}
	
	public String getSelectedTextInMonthDropdown() {
		waitToElementVisible(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
		return getFirstSelectedTextInDropdown(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
	}
	
	public String getSelectedTextInYearDropdown() {
		waitToElementVisible(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
		return getFirstSelectedTextInDropdown(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
	}
	
	public String getEmailTextboxValue() {
		waitToElementClickable(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX, "value");
	}
	
	public String getCompanyTextboxValue() {
		waitToElementClickable(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX, "value");
	}

}
