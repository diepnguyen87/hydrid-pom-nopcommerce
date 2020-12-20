package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;
import commons.AbstractPage;
import pageUIs.orangehrm.EmployeeDetailsPageUI;

public class EmployeeDetailsPO extends AbstractPage {

	private WebDriver driver;

	public EmployeeDetailsPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToFirstNameTextboxAtEmployeeForm(String firstName) {
		waitToElementVisible(driver, EmployeeDetailsPageUI.FIRST_NAME_TEXTBOX_AT_EMPLOYEE_FORM);
		sendkeyToElement(driver, EmployeeDetailsPageUI.FIRST_NAME_TEXTBOX_AT_EMPLOYEE_FORM, firstName);
	}

	public void enterToLastNameTextboxAtEmployeeForm(String lastName) {
		waitToElementVisible(driver, EmployeeDetailsPageUI.LAST_NAME_TEXTBOX_AT_EMPLOYEE_FORM);
		sendkeyToElement(driver, EmployeeDetailsPageUI.LAST_NAME_TEXTBOX_AT_EMPLOYEE_FORM, lastName);
	}

	public void clickToSaveButton() {
		waitToElementClickable(driver, EmployeeDetailsPageUI.SAVE_BUTTON_AT_EMPLOYEE_FORM);
		clickToElement(driver, EmployeeDetailsPageUI.SAVE_BUTTON_AT_EMPLOYEE_FORM);
	}

	public String getEmployeeIDAtEmployeeForm() {
		waitToElementVisible(driver, EmployeeDetailsPageUI.EMPLOYEE_ID_TEXTBOX_AT_EMPLOYEE_FORM);
		return getElementAttribute(driver, EmployeeDetailsPageUI.EMPLOYEE_ID_TEXTBOX_AT_EMPLOYEE_FORM, "value");
	}

	public Object getFirstNameValueAtPersonalDetailForm() {
		waitToElementVisible(driver, EmployeeDetailsPageUI.FIRST_NAME_TEXTBOX_AT_PERSONAL_DETAIL);
		return getElementAttribute(driver, EmployeeDetailsPageUI.FIRST_NAME_TEXTBOX_AT_PERSONAL_DETAIL, "value");
	}

	public boolean isFullNameDisplayedAtHeader(String fullName) {
		waitToElementVisible(driver, EmployeeDetailsPageUI.FULL_NAME_TEXTBOX_AT_PERSONAL_DETAIL, fullName);
		return isElementDisplay(driver, EmployeeDetailsPageUI.FULL_NAME_TEXTBOX_AT_PERSONAL_DETAIL, fullName);
	}

	public String getEmployeeIDAtPersonalDetailForm() {
		waitToElementVisible(driver, EmployeeDetailsPageUI.EMPLOYEE_ID_TEXTBOX_AT_PERSONAL_DETAIL);
		return getElementAttribute(driver, EmployeeDetailsPageUI.EMPLOYEE_ID_TEXTBOX_AT_PERSONAL_DETAIL, "value");
	}

	public String getLastNameValueAtPersonalDetailForm() {
		waitToElementVisible(driver, EmployeeDetailsPageUI.LAST_NAME_TEXTBOX_AT_PERSONAL_DETAIL);
		return getElementAttribute(driver, EmployeeDetailsPageUI.LAST_NAME_TEXTBOX_AT_PERSONAL_DETAIL, "value");
	}

	public void enterToFirstNameTextboxAtPersonalDetailForm(String firstName) {
		waitToElementVisible(driver, EmployeeDetailsPageUI.FIRST_NAME_TEXTBOX_AT_PERSONAL_DETAIL);
		sendkeyToElement(driver, EmployeeDetailsPageUI.FIRST_NAME_TEXTBOX_AT_PERSONAL_DETAIL, firstName);
	}

	public void enterToLastNameTextboxAtPersonalDetailForm(String lastName) {
		waitToElementVisible(driver, EmployeeDetailsPageUI.LAST_NAME_TEXTBOX_AT_PERSONAL_DETAIL);
		sendkeyToElement(driver, EmployeeDetailsPageUI.LAST_NAME_TEXTBOX_AT_PERSONAL_DETAIL, lastName);
	}

	public void enterToSSNTextboxAtPersonalDetailForm(String SSN) {
		waitToElementVisible(driver, EmployeeDetailsPageUI.SSN_NUMBER_TEXTBOX_AT_PERSONAL_DETAIL);
		sendkeyToElement(driver, EmployeeDetailsPageUI.SSN_NUMBER_TEXTBOX_AT_PERSONAL_DETAIL, SSN);
	}

	public void clickToGenderRadioAtPersonalDetailForm(String genderValue) {
		waitToElementClickable(driver, EmployeeDetailsPageUI.GENDER_RADIO_AT_PERSONAL_DETAIL, genderValue);
		clickToElement(driver, EmployeeDetailsPageUI.GENDER_RADIO_AT_PERSONAL_DETAIL, genderValue);
	}

	public void selectMarialStatusDropdownAtPersonalDetailForm(String marialStatusValue) {
		waitToElementClickable(driver, EmployeeDetailsPageUI.MARIAL_STATUS_AT_PERSONAL_DETAIL, marialStatusValue);
		selectItemInDropdown(driver, EmployeeDetailsPageUI.MARIAL_STATUS_AT_PERSONAL_DETAIL, marialStatusValue);
	}

	public void selectNationalityDropdownAtPersonalDetailForm(String nationalityValue) {
		waitToElementClickable(driver, EmployeeDetailsPageUI.NATIONALITY_AT_PERSONAL_DETAIL, nationalityValue);
		selectItemInDropdown(driver, EmployeeDetailsPageUI.NATIONALITY_AT_PERSONAL_DETAIL, nationalityValue);
	}

	public void selectDayOfBirthDropdownAtPersonalDetailForm(String DOBValue) {
		waitToElementClickable(driver, EmployeeDetailsPageUI.DOB_DROPDOWN_AT_PERSONAL_DETAIL, DOBValue);
		selectItemInDropdown(driver, EmployeeDetailsPageUI.DOB_DROPDOWN_AT_PERSONAL_DETAIL, DOBValue);
	}

	public String getSSNNumberAtPersonalDetailForm() {
		waitToElementVisible(driver, EmployeeDetailsPageUI.SSN_NUMBER_TEXTBOX_AT_PERSONAL_DETAIL);
		return getElementAttribute(driver, EmployeeDetailsPageUI.SSN_NUMBER_TEXTBOX_AT_PERSONAL_DETAIL, "value");
	}

	public boolean isGenderRadioSelected(String string) {
		waitToElementVisible(driver, EmployeeDetailsPageUI.GENDER_RADIO_AT_PERSONAL_DETAIL);
		return isElementSelected(driver, EmployeeDetailsPageUI.GENDER_RADIO_AT_PERSONAL_DETAIL);
	}

	public String getSelectedItemOfMarialStatusDropwdownAtPersonalDetail() {
		waitToElementVisible(driver, EmployeeDetailsPageUI.MARIAL_STATUS_AT_PERSONAL_DETAIL);
		return getFirstSelectedTextInDropdown(driver, EmployeeDetailsPageUI.MARIAL_STATUS_AT_PERSONAL_DETAIL);
	}

	public String getSelectedItemOfNationalityDropwdownAtPersonalDetail() {
		waitToElementVisible(driver, EmployeeDetailsPageUI.NATIONALITY_AT_PERSONAL_DETAIL);
		return getFirstSelectedTextInDropdown(driver, EmployeeDetailsPageUI.NATIONALITY_AT_PERSONAL_DETAIL);
	}

	public String getSuccessMessageAtPersonalDetail() {
		waitToElementVisible(driver, EmployeeDetailsPageUI.SUCESS_MESSAGE_AT_PERSONAL_DETAIL);
		return getElementText(driver, EmployeeDetailsPageUI.SUCESS_MESSAGE_AT_PERSONAL_DETAIL);
	}

	public void enterToDOBTextboxAtPersonalDetailFrom(String DOBValue) {
		waitToElementVisible(driver, EmployeeDetailsPageUI.DOB_DROPDOWN_AT_PERSONAL_DETAIL);
		sendkeyToElement(driver, EmployeeDetailsPageUI.DOB_DROPDOWN_AT_PERSONAL_DETAIL, DOBValue);
	}

	public void openSidebarTabByName(String tabName) {
		waitToElementClickable(driver, EmployeeDetailsPageUI.SIDE_BAR_TAB_BY_NAME_AT_PERSONAL_DETAIL, tabName);
		clickToElement(driver, EmployeeDetailsPageUI.SIDE_BAR_TAB_BY_NAME_AT_PERSONAL_DETAIL, tabName);
	}

	public void selectPayGradeDropdownAtSalaryForm(String payGradeValue) {
		waitToElementClickable(driver, EmployeeDetailsPageUI.PAY_GRADE_AT_SALARY, payGradeValue);
		selectItemInDropdown(driver, EmployeeDetailsPageUI.PAY_GRADE_AT_SALARY, payGradeValue);
	}

	public void enterToSalaryComponentTextboxAtSalaryForm(String salaryComponentValue) {
		waitToElementVisible(driver, EmployeeDetailsPageUI.SALARY_COMPONENT_TEXTBOX_AT_SALARY);
		sendkeyToElement(driver, EmployeeDetailsPageUI.SALARY_COMPONENT_TEXTBOX_AT_SALARY, salaryComponentValue);
	}

	public void selectPayFrequencyDropdownAtSalaryForm(String payFrequencyValue) {
		waitToElementClickable(driver, EmployeeDetailsPageUI.PAY_FREQUENCY_AT_SALARY, payFrequencyValue);
		selectItemInDropdown(driver, EmployeeDetailsPageUI.PAY_FREQUENCY_AT_SALARY, payFrequencyValue);
	}

	public void selectCurrencyDropdownAtSalaryForm(String currentValue) {
		waitToElementClickable(driver, EmployeeDetailsPageUI.CURRENCY_AT_SALARY, currentValue);
		selectItemInDropdown(driver, EmployeeDetailsPageUI.CURRENCY_AT_SALARY, currentValue);
	}

	public void enterToAmountTextboxAtSalaryForm(String amountValue) {
		waitToElementVisible(driver, EmployeeDetailsPageUI.AMOUNT_TEXTBOX_AT_SALARY);
		sendkeyToElement(driver, EmployeeDetailsPageUI.AMOUNT_TEXTBOX_AT_SALARY, amountValue);
	}

	public void enterToCommentTextAreaAtSalaryForm(String comment) {
		waitToElementVisible(driver, EmployeeDetailsPageUI.COMMENT_TEXTAREA_AT_SALARY);
		sendkeyToElement(driver, EmployeeDetailsPageUI.COMMENT_TEXTAREA_AT_SALARY, comment);
	}

}
