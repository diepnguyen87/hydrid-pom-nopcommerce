package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserOrdersHistoryPageUI;

public class UserOrdersHistoryPO extends AbstractPage{
	
	private WebDriver driver;
	
	public UserOrdersHistoryPO(WebDriver driver) {
		this.driver = driver;
	}

}
