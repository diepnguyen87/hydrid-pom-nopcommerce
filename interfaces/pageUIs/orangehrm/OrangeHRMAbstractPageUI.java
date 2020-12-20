package pageUIs.orangehrm;

public class OrangeHRMAbstractPageUI {

	public static final String DYNAMIC_MENU_BY_NAME = "//a[@class='firstLevelMenu']/b[text()='%s']";
	public static final String DYNAMIC_SUB_MENU_BY_NAME = "//a[contains(@id, 'menu') and text()='%s']";
	public static final String DYNAMIC_BUTTON_BY_NAME_AT_FORM_HEADER = "//h1[text()='%s']/parent::div/following-sibling::div//input[@value='%s']";
	
}
