package com.orangehrm.employee;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.AbstractTest;
import pageObjects.orangehrm.DashboardPO;
import pageObjects.orangehrm.EmployeeDetailsPO;
import pageObjects.orangehrm.LoginPO;
import pageObjects.orangehrm.PageGeneratorManager;
import pageObjects.orangehrm.UserDetailsPO;

public class Employee_01_Add_Edit_Employee_User extends AbstractTest {

	private WebDriver driver;
	private LoginPO loginPage;
	private DashboardPO dashboardPage;
	private EmployeeDetailsPO employeeDetailsPage;
	private UserDetailsPO userDetailsPage;
	private String firstName, lastName, employeeID;
	private String editFirstName, editLastName, editSSN, editGender, editMaritalStatus, editNationality, editDOB;
	private String payGrade, salaryComponent, payFrequency, currency, amount, comment;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String webUrl) throws Exception {

		driver = getBrowserDriver(browserName, webUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		firstName = "Automation" + getRandomNumber();
		lastName = "Testing";
		editFirstName = "Manual" + getRandomNumber();
		editLastName = "FC" + getRandomNumber();
		editSSN = "329-68-2055";
		editGender = "Male";
		editMaritalStatus = "Single";
		editNationality = "Vietnamese";
		editDOB = "2000-08-01";
		payGrade = "Grade 1";
		salaryComponent = editFirstName + " - ";
		payFrequency = "Monthly on first pay of month.";
		currency = "United States Dollar";
		amount = "55000";
		comment = "Salary per month";
		
		log.info("Pre-condition - Step 01: enter to username textbox");
		loginPage.enterToUsernameTextbox("Admin");
		
		log.info("Pre-condition - Step 02: enter to password textbox");
		loginPage.enterToPasswordTextbox("admin123");
		
		log.info("Pre-condition - Step 03: click to login button");
		dashboardPage = loginPage.clickToLoginButton();
		
	}

	@Test
	public void Employee_01_Add_Employee() {
		
		log.info("Employee_01 - Step 01: hover to menu PIM");
		dashboardPage.hoverToMenu("PIM");
		
		log.info("Employee_01 - Step 02: click to submenuAdd employee");
		employeeDetailsPage = dashboardPage.clickToSubmenu("Add Employee");
		
		log.info("Employee_01 - Step 03: enter to first name textbox");
		employeeDetailsPage.enterToFirstNameTextboxAtEmployeeForm(firstName);
		
		log.info("Employee_01 - Step 04: enter to last name textbox");
		employeeDetailsPage.enterToLastNameTextboxAtEmployeeForm(lastName);
		
		log.info("Employee_01 - Step 05: get employee id from employee form");
		employeeID = employeeDetailsPage.getEmployeeIDAtEmployeeForm();
		
		log.info("Employee_01 - Step 06: click to save button");
		employeeDetailsPage.clickToSaveButton();
		
		verifyTrue(employeeDetailsPage.isFullNameDisplayedAtHeader(firstName + " " + lastName));
		verifyEquals(employeeDetailsPage.getFirstNameValueAtPersonalDetailForm(), firstName);
		verifyEquals(employeeDetailsPage.getLastNameValueAtPersonalDetailForm(), lastName);
		verifyEquals(employeeDetailsPage.getEmployeeIDAtPersonalDetailForm(), employeeID);
		
	}
	
	@Test
	public void Employee_02_Edit_Employee_By_Personal() {
		
		log.info("Employee employee [Personal Detail] - Step 01: click to 'Edit' button at personal detail form");
		employeeDetailsPage.clickToButtonBynameAtFormHeader(driver, "Personal Details", "Edit");
		
		log.info("Employee employee [Personal Detail] - Step 02: enter " + editFirstName + " to first name textbox");
		employeeDetailsPage.enterToFirstNameTextboxAtPersonalDetailForm(editFirstName);
		
		log.info("Employee employee [Personal Detail] - Step 03: enter " + editLastName + " to last name textbox");
		employeeDetailsPage.enterToLastNameTextboxAtPersonalDetailForm(editLastName);
		
		log.info("Employee employee [Personal Detail] - Step 04: enter " + editSSN + " to social security number textbox");
		employeeDetailsPage.enterToSSNTextboxAtPersonalDetailForm(editSSN);
		
		log.info("Employee employee [Personal Detail] - Step 05: click to Gender radio with " + editGender);
		employeeDetailsPage.clickToGenderRadioAtPersonalDetailForm(editGender);
		
		log.info("Employee employee [Personal Detail] - Step 06: select to 'Marial Status' dropdown with " + editMaritalStatus);
		employeeDetailsPage.selectMarialStatusDropdownAtPersonalDetailForm(editMaritalStatus);
		
		log.info("Employee employee [Personal Detail] - Step 07: select 'Nationality' dropdown with " + editNationality);
		employeeDetailsPage.selectNationalityDropdownAtPersonalDetailForm(editNationality);
		
		log.info("Employee employee [Personal Detail] - Step 08: enter " + editDOB + " to 'Date of Birth' textbox");
		employeeDetailsPage.enterToDOBTextboxAtPersonalDetailFrom(editDOB);
		
		log.info("Employee employee [Personal Detail] - Step 09: click to 'Save' button at personal detail form");
		employeeDetailsPage.clickToButtonBynameAtFormHeader(driver, "Personal Details", "Save");
		
		log.info("Employee employee [Personal Detail] - Step 10: verify success message display with value 'Successfully saved'");
		verifyEquals(employeeDetailsPage.getSuccessMessageAtPersonalDetail(), "Successfully Saved");
		
		log.info("Employee employee [Personal Detail] - Step 11: verify first name textbox edited successfully");
		verifyEquals(employeeDetailsPage.getFirstNameValueAtPersonalDetailForm(), editFirstName);
		
		log.info("Employee employee [Personal Detail] - Step 12: verify last name textbox edited successfully");
		verifyEquals(employeeDetailsPage.getLastNameValueAtPersonalDetailForm(), editLastName);
		
		log.info("Employee employee [Personal Detail] - Step 13: verify SSN number edited successfully");
		verifyEquals(employeeDetailsPage.getSSNNumberAtPersonalDetailForm(), editSSN);
		
		log.info("Employee employee [Personal Detail] - Step 14: verify gender radio edited successfully");
		verifyTrue(employeeDetailsPage.isGenderRadioSelected(editGender));
		
		log.info("Employee employee [Personal Detail] - Step 15: verify Marial Status edited successfully");
		verifyEquals(employeeDetailsPage.getSelectedItemOfMarialStatusDropwdownAtPersonalDetail(), editMaritalStatus);
		
		log.info("Employee employee [Personal Detail] - Step 16: verify Nationality edited successfully");
		verifyEquals(employeeDetailsPage.getSelectedItemOfNationalityDropwdownAtPersonalDetail(), editNationality);
		
	}
	
	@Test
	public void Employee_03_Edit_Employee_By_Contact() {
		
	}
	
	@Test
	public void Employee_04_Edit_Employee_By_Job() {
		
	}
	
	@Test
	public void Employee_05_Edit_Employee_By_Salary() {
		
		log.info("Employee employee [Salary] - Step 01: open 'Salary' tab");
		employeeDetailsPage.openSidebarTabByName("Salary");
		
		log.info("Employee employee [Salary] - Step 02: click to 'Add' button at Salary form");
		employeeDetailsPage.clickToButtonBynameAtFormHeader(driver, "Assigned Salary Components", "Add");
		
		log.info("Employee employee [Salary] - Step 03: select to 'Pay Grade' dropdown with " + payGrade);
		employeeDetailsPage.selectPayGradeDropdownAtSalaryForm(payGrade);
		
		log.info("Employee employee [Salary] - Step 04: select to 'Salary Component' dropdown with " + salaryComponent);
		employeeDetailsPage.enterToSalaryComponentTextboxAtSalaryForm(salaryComponent);
		
		log.info("Employee employee [Salary] - Step 05: select to 'Pay Frequency' dropdown with " + payFrequency);
		employeeDetailsPage.selectPayFrequencyDropdownAtSalaryForm(payFrequency);
		
		log.info("Employee employee [Salary] - Step 06: select to 'Currency' dropdown with " + currency);
		employeeDetailsPage.selectCurrencyDropdownAtSalaryForm(currency);
	
		log.info("Employee employee [Salary] - Step 07: Enter " + amount + " to 'Amount' textbox");
		employeeDetailsPage.enterToAmountTextboxAtSalaryForm(amount);
		
		log.info("Employee employee [Salary] - Step 08: Enter " + comment + " to 'Comments' text area");
		employeeDetailsPage.enterToCommentTextAreaAtSalaryForm(comment);
		
		log.info("Employee employee [Salary] - Step 02: click to 'Save' button at Add Salary Component");
		employeeDetailsPage.clickToButtonBynameAtFormHeader(driver, "Add Salary Component", "Save");
	}
	
	@Test
	public void Employee_06_Search_Employee() {
		
	}
	
	@Test
	public void Employee_07_Add_User_To_Employee() {
		
	}
	
	@Test
	public void Employee_08_Search_User() {
		
	}

	@Test
	public void Employee_09_Delete_User() {
		
	}
	
	@Test
	public void Employee_10_Delete_Employee() {
		
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		//closeBrowserAndDriver(driver);
	}

}
