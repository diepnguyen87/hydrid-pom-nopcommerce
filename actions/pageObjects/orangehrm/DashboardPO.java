package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.orangehrm.AbstractPageUI;
import pageUIs.orangehrm.EmployeeDetailsPageUI;

public class DashboardPO extends AbstractPage{

	private WebDriver driver;
	
	public DashboardPO(WebDriver driver) {
		this.driver = driver;
	}

	public EmployeeDetailsPO clickToSubmenu(String subMenuName) {
		waitToElementClickable(driver, AbstractPageUI.DYNAMIC_SUB_MENU_BY_NAME, subMenuName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_SUB_MENU_BY_NAME, subMenuName);
		return PageGeneratorManager.getEmployeeDetailsPage(driver);
	}

	public void hoverToMenu(String mainMenuName) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_MENU_BY_NAME, mainMenuName);
		hoverMouseToElement(driver, AbstractPageUI.DYNAMIC_MENU_BY_NAME, mainMenuName);
	}
	

}
