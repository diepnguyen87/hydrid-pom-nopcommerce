package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.orangehrm.OrangeHRMAbstractPageUI;
import pageUIs.orangehrm.EmployeeDetailsPageUI;

public class DashboardPO extends AbstractPage{

	private WebDriver driver;
	
	public DashboardPO(WebDriver driver) {
		this.driver = driver;
	}

	public EmployeeDetailsPO clickToSubmenu(String subMenuName) {
		waitToElementClickable(driver, OrangeHRMAbstractPageUI.DYNAMIC_SUB_MENU_BY_NAME, subMenuName);
		clickToElement(driver, OrangeHRMAbstractPageUI.DYNAMIC_SUB_MENU_BY_NAME, subMenuName);
		return PageGeneratorManager.getEmployeeDetailsPage(driver);
	}

	public void hoverToMenu(String mainMenuName) {
		waitToElementVisible(driver, OrangeHRMAbstractPageUI.DYNAMIC_MENU_BY_NAME, mainMenuName);
		hoverMouseToElement(driver, OrangeHRMAbstractPageUI.DYNAMIC_MENU_BY_NAME, mainMenuName);
	}

	public void clickToMenu(String menuName) {
		waitToElementClickable(driver, OrangeHRMAbstractPageUI.DYNAMIC_MENU_BY_NAME, menuName);
		clickToElement(driver, OrangeHRMAbstractPageUI.DYNAMIC_MENU_BY_NAME, menuName);
	}
	

}
