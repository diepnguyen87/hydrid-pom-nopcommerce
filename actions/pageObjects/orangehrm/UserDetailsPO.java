package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;
import commons.AbstractPage;

public class UserDetailsPO extends AbstractPage{

	private WebDriver driver;
	
	public UserDetailsPO(WebDriver driver) {
		this.driver = driver;
	}

}
