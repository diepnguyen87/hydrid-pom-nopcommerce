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
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String webUrl) throws Exception {

		driver = getBrowserDriver(browserName, webUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
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
		employeeDetailsPage.enterToFirstNameTextbox("Diep");
		
		log.info("Employee_01 - Step 04: enter to last name textbox");
		employeeDetailsPage.enterToLastNameTextbox("Nguyen");
		
		log.info("Employee_01 - Step 05: click to save button");
		employeeDetailsPage.clickToSaveButton();
	}
	
	@Test
	public void Employee_02_Search_Employee() {
		
	}
	
	@Test
	public void Employee_03_Edit_Employee_By_Personal() {
		
	}
	
	@Test
	public void Employee_04_Edit_Employee_By_Contact() {
		
	}
	
	@Test
	public void Employee_05_Edit_Employee_By_Job() {
		
	}
	
	@Test
	public void Employee_06_Edit_Employee_By_Salary() {
		
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
