package pageUIs;

public class AbstractPageUI {

	public static final String ADDRESSES_LINK = "//div[@class= 'listbox']//a[text()='Addresses']";
	public static final String ORDERS_HISTORY_LINK = "//div[@class= 'listbox']//a[text()='Orders']";
	public static final String MY_PRODUCT_REVIEWS_LINK = "//div[@class= 'listbox']//a[text()='My product reviews']";
	public static final String CUSTOMER_INFO_LINK = "//div[@class= 'listbox']//a[text()='Customer info']";
	
	public static final String DYNAMIC_LINK = "//div[@class= 'listbox']//a[text()='%s']";
	public static final String LOADING_ICON = "//div[@id='ajaxBusy']";
	
	//product detail
	public static final String UPLOAD_FILE_BY_PANEL_ID = "//div[@id='%s']//input[@type='file']";
	public static final String UPLOAD_FILE= "//input[@type='file']";
	public static final String PANEL_BY_ID = "//div[@id='%s']";
	//public static final String OPENED_PANEL_BY_ID = "//div[@id='%s']/div[contains(@class, 'opened')]";
	public static final String EXPANDED_ICON_BY_PANEL_ID = "//div[@id='%s']//i[contains(@class, 'toggle-icon')]";
	public static final String COLUMN_NAME_BY_PANEL_ID = "//div[@id='%s']//th[text()='%s']/preceding-sibling::th";
	public static final String CELL_BY_PANEL_ID = "//div[@id='%s']//tr[%s]/td[%s]";
	public static final String PICTURE_PANEL_DETAIL = "//a[contains(@href,'%s')]/parent::td/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']";

}
