package com.orangehrm.employee;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.orangehrm.DashboardPO;
import pageObjects.orangehrm.EmployeeDetailsPO;
import pageObjects.orangehrm.EmployeeListPO;
import pageObjects.orangehrm.LoginPO;
import pageObjects.orangehrm.PageGeneratorManager;
import pageObjects.orangehrm.UserDetailsPO;

public class Employee_01_Add_Edit_Employee_User extends AbstractTest {

	private WebDriver driver;
	private LoginPO loginPage;
	private DashboardPO dashboardPage;
	private EmployeeListPO employeeListPage;
	private EmployeeDetailsPO employeeDetailsPage;
	private UserDetailsPO userDetailsPage;
	private String firstName, lastName, employeeID;
	private String editFirstName, editLastName, editSSN, editGender, editMaritalStatus, editNationality, editDOB;
	private String payGrade, salaryComponent, payFrequency, currency, amount, comment;
	private String jobTitle, employeeStatus, jobCategory, joinedDate, subUnit, location, startDate, endDate;
	private String supervisorName, reportingMethod;
	private String employeeName;

	@Parameters({ "browser", "url" })
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

		jobTitle = "QA Engineer";
		employeeStatus = "Full-Time Contract";
		jobCategory = "Technicians";
		joinedDate = "2010-10-01";
		subUnit = "  Quality Assurance";
		location = "New York Sales Office";
		startDate = "2010-10-01";
		endDate = "2019-10-01";

		supervisorName = "Anthony Nolan";
		reportingMethod = "Direct";

		employeeName = firstName + " " + lastName;

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

	// @Test
	public void Employee_02_Edit_Employee_By_Personal() {

		log.info("Employee_02 [Personal Detail] - Step 01: click to 'Edit' button at personal detail form");
		employeeDetailsPage.clickToButtonBynameAtFormHeader(driver, "Personal Details", "Edit");

		log.info("Employee_02 [Personal Detail] - Step 02: enter " + editFirstName + " to first name textbox");
		employeeDetailsPage.enterToFirstNameTextboxAtPersonalDetailForm(editFirstName);

		log.info("Employee_02 [Personal Detail] - Step 03: enter " + editLastName + " to last name textbox");
		employeeDetailsPage.enterToLastNameTextboxAtPersonalDetailForm(editLastName);

		log.info("Employee_02 [Personal Detail] - Step 04: enter " + editSSN + " to social security number textbox");
		employeeDetailsPage.enterToSSNTextboxAtPersonalDetailForm(editSSN);

		log.info("Employee_02 [Personal Detail] - Step 05: click to Gender radio with " + editGender);
		employeeDetailsPage.clickToGenderRadioAtPersonalDetailForm(editGender);

		log.info("Employee_02 [Personal Detail] - Step 06: select to 'Marial Status' dropdown with " + editMaritalStatus);
		employeeDetailsPage.selectMarialStatusDropdownAtPersonalDetailForm(editMaritalStatus);

		log.info("Employee_02 [Personal Detail] - Step 07: select 'Nationality' dropdown with " + editNationality);
		employeeDetailsPage.selectNationalityDropdownAtPersonalDetailForm(editNationality);

		log.info("Employee_02 [Personal Detail] - Step 08: enter " + editDOB + " to 'Date of Birth' textbox");
		employeeDetailsPage.enterToDOBTextboxAtPersonalDetailFrom(editDOB);

		log.info("Employee_02 [Personal Detail] - Step 09: click to 'Save' button at personal detail form");
		employeeDetailsPage.clickToButtonBynameAtFormHeader(driver, "Personal Details", "Save");

		log.info("Employee_02 [Personal Detail] - Step 10: verify success message display with value 'Successfully saved'");
		verifyEquals(employeeDetailsPage.getSuccessMessageAtPersonalDetail(), "Successfully Saved");

		log.info("Employee_02 [Personal Detail] - Step 11: verify first name textbox edited successfully");
		verifyEquals(employeeDetailsPage.getFirstNameValueAtPersonalDetailForm(), editFirstName);

		log.info("Employee_02 [Personal Detail] - Step 12: verify last name textbox edited successfully");
		verifyEquals(employeeDetailsPage.getLastNameValueAtPersonalDetailForm(), editLastName);

		log.info("Employee_02 [Personal Detail] - Step 13: verify SSN number edited successfully");
		verifyEquals(employeeDetailsPage.getSSNNumberAtPersonalDetailForm(), editSSN);

		log.info("Employee_02 [Personal Detail] - Step 14: verify gender radio edited successfully");
		verifyTrue(employeeDetailsPage.isGenderRadioSelected(editGender));

		log.info("Employee_02 [Personal Detail] - Step 15: verify Marial Status edited successfully");
		verifyEquals(employeeDetailsPage.getSelectedItemOfMarialStatusDropwdownAtPersonalDetail(), editMaritalStatus);

		log.info("Employee_02 [Personal Detail] - Step 16: verify Nationality edited successfully");
		verifyEquals(employeeDetailsPage.getSelectedItemOfNationalityDropwdownAtPersonalDetail(), editNationality);

	}

	// @Test
	public void Employee_03_Edit_Employee_By_Job() {
		log.info("Employee_03 [Job] - Step 01: open 'Job' tab");
		employeeDetailsPage.openSidebarTabByName("Job");

		log.info("Employee_03 [Job] - Step 02: click to 'Edit' button at Job form");
		employeeDetailsPage.clickToButtonBynameAtFormHeader(driver, "Job", "Edit");

		log.info("Employee_03 [Job] - Step 03: select to 'Job Title' dropdown with " + jobTitle);
		employeeDetailsPage.selectJobTitleDropDownAtJobForm(jobTitle);

		log.info("Employee_03 [Job] - Step 04: select to 'Employee Status' dropdown with " + employeeStatus);
		employeeDetailsPage.selectEmployeeStatusDropDownAtJobForm(employeeStatus);

		log.info("Employee_03 [Job] - Step 05: select to 'Job Category' dropdown with " + jobCategory);
		employeeDetailsPage.selectJobCategoryDropDownAtJobForm(jobCategory);

		log.info("Employee_03 [Job] - Step 06: select to 'Sub Unit' dropdown with " + subUnit);
		employeeDetailsPage.selectSubUnitDropDownAtJobForm(subUnit);

		log.info("Employee_03 [Job] - Step 07: select to 'Joined Date' dropdown with " + joinedDate);
		employeeDetailsPage.selectJoinedDateDropDownAtJobForm(joinedDate);

		log.info("Employee_03 [Job] - Step 08: select to 'Location' dropdown with " + location);
		employeeDetailsPage.selectLocationDropDownAtJobForm(location);

		log.info("Employee_03 [Job] - Step 09: Enter " + startDate + " to 'Start Date' textbox");
		employeeDetailsPage.enterToStartDateTextboxAtJobForm(startDate);

		log.info("Employee_03 [Job] - Step 10: Enter " + endDate + " to 'End Date' textbox");
		employeeDetailsPage.enterToEndateDateTextboxAtJobForm(endDate);

		log.info("Employee_03 [Job] - Step 11: click to 'Save' button at Job form");
		employeeDetailsPage.clickToButtonBynameAtFormHeader(driver, "Job", "Save");

		verifyEquals(employeeDetailsPage.getSelectedItemOfJobTitleDropDownAtJobForm(), jobTitle);
		verifyEquals(employeeDetailsPage.getSelectedItemOfEmployeeStatusDropDownAtJobForm(), employeeStatus);
		verifyEquals(employeeDetailsPage.getSelectedItemOfJobCategoryDropDownAtJobForm(), jobCategory);
		verifyEquals(employeeDetailsPage.getJoinedDateValueAtJobForm(), joinedDate);
		verifyEquals(employeeDetailsPage.getSelectedItemOfSubUnitDropDownAtJobForm(), subUnit);
		verifyEquals(employeeDetailsPage.getSelectedItemOfLocationDropDownAtJobForm(), location);
		verifyEquals(employeeDetailsPage.getStartDateValueAtJobForm(), startDate);
		verifyEquals(employeeDetailsPage.getEndDateValueAtJobForm(), endDate);
	}

	// @Test
	public void Employee_04_Edit_Employee_By_Salary() {

		log.info("Employee_04 [Salary] - Step 01: open 'Salary' tab");
		employeeDetailsPage.openSidebarTabByName("Salary");

		log.info("Employee_04 [Salary] - Step 02: click to 'Add' button at Salary form");
		employeeDetailsPage.clickToButtonBynameAtFormHeader(driver, "Assigned Salary Components", "Add");

		log.info("Employee_04 [Salary] - Step 03: select to 'Pay Grade' dropdown with " + payGrade);
		employeeDetailsPage.selectPayGradeDropdownAtSalaryForm(payGrade);

		log.info("Employee_04 [Salary] - Step 04: select to 'Salary Component' dropdown with " + salaryComponent);
		employeeDetailsPage.enterToSalaryComponentTextboxAtSalaryForm(salaryComponent);

		log.info("Employee_04 [Salary] - Step 05: select to 'Pay Frequency' dropdown with " + payFrequency);
		employeeDetailsPage.selectPayFrequencyDropdownAtSalaryForm(payFrequency);

		log.info("Employee_04 [Salary] - Step 06: select to 'Currency' dropdown with " + currency);
		employeeDetailsPage.selectCurrencyDropdownAtSalaryForm(currency);

		log.info("Employee_04 [Salary] - Step 07: Enter " + amount + " to 'Amount' textbox");
		employeeDetailsPage.enterToAmountTextboxAtSalaryForm(amount);

		log.info("Employee_04 [Salary] - Step 08: Enter " + comment + " to 'Comments' text area");
		employeeDetailsPage.enterToCommentTextAreaAtSalaryForm(comment);

		log.info("Employee_04 [Salary] - Step 09: click to 'Save' button at Add Salary Component");
		employeeDetailsPage.clickToButtonBynameAtFormHeader(driver, "Add Salary Component", "Save");

		verifyTrue(employeeDetailsPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "tblSalary", "Pay Frequency", "1", payFrequency));
		verifyTrue(employeeDetailsPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "tblSalary", "Currency", "1", currency));
		verifyTrue(employeeDetailsPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "tblSalary", "Amount", "1", amount));
	}

	@Test
	public void Employee_05_Edit_Employee_By_Report_To() {
		log.info("Employee_05 [Report To] - Step 01: open 'Report to' tab");
		employeeDetailsPage.openSidebarTabByName("Report-to");

		log.info("Employee_05 [Report To] - Step 02: click to 'Add' button at Assigned Supervisors");
		employeeDetailsPage.clickToButtonBynameAtFormHeader(driver, "Assigned Supervisors", "Add");

		log.info("Employee_05 [Report To] - Step 03: Enter " + supervisorName + " to 'Name' text area");
		employeeDetailsPage.enterToNameTextAreaAtReportForm(supervisorName);

		log.info("Employee_05 [Report To] - Step 04: select to 'Reporting Method' dropdown with " + reportingMethod);
		employeeDetailsPage.selectReportingMethodDropdownAtSalaryForm(reportingMethod);

		log.info("Employee_05 [Salary] - Step 05: click to 'Save' button at Add Supervisor");
		employeeDetailsPage.clickToButtonBynameAtFormHeader(driver, "Add Supervisor", "Save");

		verifyTrue(employeeDetailsPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "sup_list", "Name", "1", supervisorName));
		verifyTrue(employeeDetailsPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "sup_list", "Reporting Method", "1", reportingMethod));

	}

	@Test
	public void Employee_06_Search_Employee() {

		/* Search by employee name */
		log.info("Employee_06 - Step 01: click to menu PIM");
		dashboardPage.clickToMenu("PIM");
		employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);

		log.info("Employee_06 - Step 02: Enter " + employeeName + " to 'Employee Name' textbox");
		employeeListPage.enterToEmployeeNameTextbox(employeeName);

		log.info("Employee_06 - Step 03: click to 'Search' button at Employee Information");
		employeeListPage.clickToButtonBynameAtFormHeader(driver, "Employee Information", "Search");

		log.info("Employee_06 - Step 04: verify 'First (& Middle) Name' column display with value " + firstName);
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "First (& Middle) Name", "1", firstName));

		log.info("Employee_06 - Step 05: verify 'Last Name' column display with value " + lastName);
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Last Name", "1", lastName));

		/* Search by employee ID */
		log.info("Employee_06 - Step 06: click to 'Reset' button at Employee Information");
		employeeListPage.clickToButtonBynameAtFormHeader(driver, "Employee Information", "Reset");

		log.info("Employee_06 - Step 07: Enter " + employeeID + " to 'ID' textbox");
		employeeListPage.enterToEmployeeIDTextbox(employeeID);

		log.info("Employee_06 - Step 08: click to 'Search' button at Employee Information");
		employeeListPage.clickToButtonBynameAtFormHeader(driver, "Employee Information", "Search");

		log.info("Employee_06 - Step 09: verify 'First (& Middle) Name' column display with value " + firstName);
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Id", "1", employeeID));

		/* Search by employee Name + Supervisor Name */
		log.info("Employee_06 - Step 10: click to 'Reset' button at Employee Information");
		employeeListPage.clickToButtonBynameAtFormHeader(driver, "Employee Information", "Reset");
		
		log.info("Employee_06 - Step 11: Enter " + employeeName + " to 'Employee Name' textbox");
		employeeListPage.enterToEmployeeNameTextbox(employeeName);
		
		log.info("Employee_06 - Step 12: Enter " + supervisorName + " to 'Supervisor Name' textbox");
		employeeListPage.enterToSupervisorNameTextbox(supervisorName);
		
		log.info("Employee_06 - Step 13: click to 'Search' button at Employee Information");
		employeeListPage.clickToButtonBynameAtFormHeader(driver, "Employee Information", "Search");
		
		log.info("Employee_06 - Step 14: verify 'First (& Middle) Name' column display with value " + firstName);
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "First (& Middle) Name", "1", firstName));

		log.info("Employee_06 - Step 15: verify 'Last Name' column display with value " + lastName);
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Last Name", "1", lastName));

		log.info("Employee_06 - Step 16: verify 'Supervisor' column display with value " + supervisorName);
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Supervisor", "1", supervisorName));
		
		/*
		 * log.info("Employee_06 - Step 04: select to 'Employee Status' dropdown with " + employeeStatus);
		 * employeeDetailsPage.selectEmployeeStatusDropDown(employeeStatus);
		 * 
		 * log.info("Employee_06 - Step 05: select to 'Include' dropdown with " + include); employeeDetailsPage.selectIncludeDropDown(include);
		 */

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
		// closeBrowserAndDriver(driver);
	}

}
