package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	public static LoginPO getLoginPage(WebDriver driver) {
		return new LoginPO(driver);
	}
	
	public static DashboardPO getDashboardPage(WebDriver driver) {
		return new DashboardPO(driver);
	}
	
	public static EmployeeDetailsPO getEmployeeDetailsPage(WebDriver driver) {
		return new EmployeeDetailsPO(driver);
	}
	
	public static UserDetailsPO getUserDetailsPage(WebDriver driver) {
		return new UserDetailsPO(driver);
	}
}
