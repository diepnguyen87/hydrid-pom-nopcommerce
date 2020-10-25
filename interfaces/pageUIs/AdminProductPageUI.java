package pageUIs;

public class AdminProductPageUI {

	public static final String PAGING_AT_TABLE_BY_INDEX = "//li[@class='paginate_button ']/a[text()='%s']";
	public static final String PAGING_AT_TABLE_ACTIVE_BY_INDEX = "//li[@class='paginate_button active']/a[text()='%s']";
	public static final String SELECT_ALL_CHECKBOX = "//th/input[@id='mastercheckbox']";
	public static final String ALL_PRODUCT_CHECKBOX = "//input[@name='checkbox_products']";
	public static final String PRODUCT_CHECKBOX_BY_NAME = "//td[text()='%s']/preceding-sibling::td/input";
	//public static final String PRODUCT_DETAIL = "//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td/i[contains(@class,'%s-icon')]";
	public static final String PRODUCT_DETAIL = "//img[contains(@src,'%s')]/parent::td/following-sibling::td[text()='AD_CS4_PH']/following-sibling::td[text()='75']/following-sibling::td[text()='10000']/following-sibling::td[text()='Simple']/following-sibling::td/i[contains(@class,'true-icon')]";
	public static final String SHOW_ITEMS_DROPDOWN = "//select[@name='products-grid_length']";
	public static final String COLUMN_NAME_SIBLING = "//th[text()='%s']/preceding-sibling::th";
	public static final String CELL_DETAIL = "//tr[%s]/td[%s]";
	public static final String PUBLISH_STATUS_CELL = "//tr[%s]/td[%s]/i[contains(@class, '%s-icon')]";
	public static final String EDIT_BUTTON_BY_PRODUCT_NAME = "//td[text()='%s']/following-sibling::td/a";
	public static final String PRODUCT_NAME_TEXTBOX = "//input[@id='SearchProductName']";
	public static final String SEARCH_BUTTON = "//button[@id='search-products']";
	
	//product detail
	public static final String PICTURE_PANEL = "//div[@id='product-pictures']";
	public static final String ALT_TEXTBOX = "//input[@id='AddPictureModel_OverrideAltAttribute']";
	public static final String TITLE_TEXTBOX = "//input[@id='AddPictureModel_OverrideTitleAttribute']";
	public static final String INCREASE_DECREASE_ICON_FOR_ORDER = "//input[@id='AddPictureModel_DisplayOrder']/following-sibling::span[@class='k-select']/span[contains(@title, '%s')]";
	public static final String ORDER_TEXTBOX = "//input[@id='AddPictureModel_DisplayOrder']/preceding-sibling::input";
	public static final String ADD_PRODUCT_PICTURE_BUTTON = "//button[@id='addProductPicture']";
	public static final String PANEL_PICTURE_CELL_BY_ORDER_NUMBER = "//td[text()='%s']/preceding-sibling::td/a";
	public static final String SAVE_BUTTON = "//button[@name='save']";
	public static final String QQ_UPLOAD_BUTTON_BY_PANEL_ID = "//div[@id='%s']//span[contains(@class, 'qq-upload-file')]";
	public static final String DELETE_BUTTON_BY_PICTURE_TITLE = "//td[@data-columnname='OverrideTitleAttribute' and text()='%s']//following-sibling::td[@data-columnname='Id']//i[contains(@class,'fa-remove')]";
}
