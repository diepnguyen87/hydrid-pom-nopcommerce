package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;
import commons.AbstractPage;
import pageUIs.orangehrm.EmployeeDetailsPageUI;

public class EmployeeDetailsPO extends AbstractPage{

	private WebDriver driver;
	
	public EmployeeDetailsPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToFirstNameTextbox(String firstName) {
		waitToElementVisible(driver, EmployeeDetailsPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, EmployeeDetailsPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void enterToLastNameTextbox(String lastName) {
		waitToElementVisible(driver, EmployeeDetailsPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, EmployeeDetailsPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public void clickToSaveButton() {
		waitToElementClickable(driver, EmployeeDetailsPageUI.SAVE_BUTTON);
		clickToElement(driver, EmployeeDetailsPageUI.SAVE_BUTTON);
	}

}
