package pageObjects;

import org.openqa.selenium.WebDriver;
import commons.AbstractPage;
import pageUIs.CustomerPageUI;

public class UserCustomerInfoPO extends AbstractPage{

	private WebDriver driver;
	
	public UserCustomerInfoPO(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isGenderMaleRadioButtonSelected() {
		waitToElementVisible(driver, CustomerPageUI.GENDER_MALE_RADIO);
		return isElementSelected(driver, CustomerPageUI.GENDER_MALE_RADIO);
	}
	
	public String getFirstNameTextboxValue() {
		waitToElementVisible(driver, CustomerPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.FIRSTNAME_TEXTBOX, "value");
	}
	
	public String getLastNameTextboxvalue() {
		waitToElementVisible(driver, CustomerPageUI.LASTNAME_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.LASTNAME_TEXTBOX, "value");
	}
	
	public String getSelectedTextInDayDropdown() {
		waitToElementVisible(driver, CustomerPageUI.DAY_DROPDOWN);
		return getFirstSelectedTextInDropdown(driver, CustomerPageUI.DAY_DROPDOWN);
	}
	
	public String getSelectedTextInMonthDropdown() {
		waitToElementVisible(driver, CustomerPageUI.MONTH_DROPDOWN);
		return getFirstSelectedTextInDropdown(driver, CustomerPageUI.MONTH_DROPDOWN);
	}
	
	public String getSelectedTextInYearDropdown() {
		waitToElementVisible(driver, CustomerPageUI.YEAR_DROPDOWN);
		return getFirstSelectedTextInDropdown(driver, CustomerPageUI.YEAR_DROPDOWN);
	}
	
	public String getEmailTextboxValue() {
		waitToElementClickable(driver, CustomerPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.EMAIL_TEXTBOX, "value");
	}
	
	public String getCompanyTextboxValue() {
		waitToElementClickable(driver, CustomerPageUI.COMPANY_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.COMPANY_TEXTBOX, "value");
	}
	
}
