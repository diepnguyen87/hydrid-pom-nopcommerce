package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.orangehrm.EmployeeListPageUI;

public class EmployeeListPO extends AbstractPage{

	private WebDriver driver;
	
	public EmployeeListPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToEmployeeNameTextbox(String employeeName) {
		waitToElementInvisible(driver, EmployeeListPageUI.EMPLOYEE_NAME_LOADING_ICON);
		waitToElementVisible(driver, EmployeeListPageUI.EMPLOYEE_NAME_TEXTBOX);
		sendkeyToElement(driver, EmployeeListPageUI.EMPLOYEE_NAME_TEXTBOX, employeeName);
	}

	public void enterToEmployeeIDTextbox(String employeeID) {
		waitToElementVisible(driver, EmployeeListPageUI.EMPLOYEE_ID_TEXTBOX);
		sendkeyToElement(driver, EmployeeListPageUI.EMPLOYEE_ID_TEXTBOX, employeeID);
	}

	public void enterToSupervisorNameTextbox(String supervisorName) {
		waitToElementVisible(driver, EmployeeListPageUI.SUPERVISOR_NAME_TEXTBOX);
		sendkeyToElement(driver, EmployeeListPageUI.SUPERVISOR_NAME_TEXTBOX, supervisorName);
	}

}
