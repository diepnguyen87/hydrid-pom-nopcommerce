package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	public static UserLoginPO getUserLoginPage(WebDriver driver) {
		return new UserLoginPO(driver);
	}
	
	public static UserHomePO getUserHomePage(WebDriver driver) {
		return new UserHomePO(driver);
	}
	
	public static UserRegisterPO getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPO(driver);
	}
	
	public static UserCustomerInfoPO getUserCustomerInfoPage(WebDriver driver) {
		return new UserCustomerInfoPO(driver);
	}
	
	public static UserCustomerAddressesPO getUserCustomerAddressesPage(WebDriver driver) {
		return new UserCustomerAddressesPO(driver);
	}
	
	public static UserOrdersHistoryPO getUserOrdersHistoryPage(WebDriver driver) {
		return new UserOrdersHistoryPO(driver);
	}
	
	public static UserCustomerProductReviewsPO getUserCustomerProductReviewsPage(WebDriver driver) {
		return new UserCustomerProductReviewsPO(driver);
	}
	
	public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPO(driver);
	}
	
	public static AdminDashboardPO getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPO(driver);
	}
	
	public static AdminProductPO getAdminProductPage(WebDriver driver) {
		return new AdminProductPO(driver);
	}
	
}
