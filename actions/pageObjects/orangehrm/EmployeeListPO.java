package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;
import commons.AbstractPage;

public class EmployeeListPO extends AbstractPage{

	private WebDriver driver;
	
	public EmployeeListPO(WebDriver driver) {
		this.driver = driver;
	}

}
