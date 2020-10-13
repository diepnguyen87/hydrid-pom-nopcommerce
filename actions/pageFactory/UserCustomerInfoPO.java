package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserCustomerInfoPO extends AbstractPage{

	private WebDriver driver;

	@FindBy(id = "gender-male")
	private WebElement genderMaleRadio;
	
	@FindBy(id = "FirstName")
	private WebElement firstNameTextbox;
	
	@FindBy(id = "LastName")
	private WebElement lastNameTextbox;
	
	@FindBy(name = "DateOfBirthDay")
	private WebElement dayDropdown;
	
	@FindBy(name = "DateOfBirthMonth")
	private WebElement monthDropdown;
	
	@FindBy(name = "DateOfBirthYear")
	private WebElement yearDropdown;
	
	@FindBy(id = "Email")
	private WebElement emailTextbox;
	
	@FindBy(id = "Company")
	private WebElement companyTextbox;
	
	public UserCustomerInfoPO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isGenderMaleRadioButtonSelected() {
		waitToElementVisible(driver, genderMaleRadio);
		return isElementSelected(driver, genderMaleRadio);
	}
	
	public String getFirstNameTextboxValue() {
		waitToElementVisible(driver, firstNameTextbox);
		return getElementAttribute(driver, firstNameTextbox, "value");
	}
	
	public String getLastNameTextboxvalue() {
		waitToElementVisible(driver, lastNameTextbox);
		return getElementAttribute(driver, lastNameTextbox, "value");
	}
	
	public String getSelectedTextInDayDropdown() {
		waitToElementVisible(driver, dayDropdown);
		return getFirstSelectedTextInDropdown(driver, dayDropdown);
	}
	
	public String getSelectedTextInMonthDropdown() {
		waitToElementVisible(driver, monthDropdown);
		return getFirstSelectedTextInDropdown(driver, monthDropdown);
	}
	
	public String getSelectedTextInYearDropdown() {
		waitToElementVisible(driver, yearDropdown);
		return getFirstSelectedTextInDropdown(driver, yearDropdown);
	}
	
	public String getEmailTextboxValue() {
		waitToElementClickable(driver, emailTextbox);
		return getElementAttribute(driver, emailTextbox, "value");
	}
	
	public String getCompanyTextboxValue() {
		waitToElementClickable(driver, companyTextbox);
		return getElementAttribute(driver, companyTextbox, "value");
	}
	
}
