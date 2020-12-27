package pageUIs.orangehrm;

public class EmployeeDetailsPageUI {

	/* Add Employee */
	public static final String FIRST_NAME_TEXTBOX_AT_EMPLOYEE_FORM = "//input[@id='firstName']";
	public static final String LAST_NAME_TEXTBOX_AT_EMPLOYEE_FORM = "//input[@id='lastName']";
	public static final String EMPLOYEE_ID_TEXTBOX_AT_EMPLOYEE_FORM = "//input[@id='employeeId']";
	public static final String SAVE_BUTTON_AT_EMPLOYEE_FORM = "//input[@id='btnSave']";
	
	/* Personal Detail */
	public static final String FULL_NAME_TEXTBOX_AT_PERSONAL_DETAIL = "//div[@id='profile-pic']/h1[text()='%s']";
	public static final String FIRST_NAME_TEXTBOX_AT_PERSONAL_DETAIL = "//input[@id='personal_txtEmpFirstName']";
	public static final String LAST_NAME_TEXTBOX_AT_PERSONAL_DETAIL = "//input[@id='personal_txtEmpLastName']";
	public static final String EMPLOYEE_ID_TEXTBOX_AT_PERSONAL_DETAIL = "//input[@id='personal_txtEmployeeId']";
	public static final String SSN_NUMBER_TEXTBOX_AT_PERSONAL_DETAIL = "//input[@id='personal_txtNICNo']";
	public static final String GENDER_RADIO_AT_PERSONAL_DETAIL = "//label[text()='Male']/preceding-sibling::input[@id=\"personal_optGender_1\"]";
	public static final String MARIAL_STATUS_AT_PERSONAL_DETAIL = "//select[@id='personal_cmbMarital']";
	public static final String NATIONALITY_AT_PERSONAL_DETAIL = "//select[@id='personal_cmbNation']";
	public static final String DOB_DROPDOWN_AT_PERSONAL_DETAIL = "//input[@id='personal_DOB']";
	public static final String SUCESS_MESSAGE_AT_PERSONAL_DETAIL = "//div[contains(@class, 'message success')]";
	public static final String SIDE_BAR_TAB_BY_NAME_AT_PERSONAL_DETAIL = "//ul[@id='sidenav']//a[text()='%s']";
	
	/* Salary */
	public static final String PAY_GRADE_AT_SALARY = "//select[@id='salary_sal_grd_code']";
	public static final String SALARY_COMPONENT_TEXTBOX_AT_SALARY = "//input[@id='salary_salary_component']";
	public static final String PAY_FREQUENCY_AT_SALARY = "//select[@id='salary_payperiod_code']";
	public static final String CURRENCY_AT_SALARY = "//select[@id='salary_currency_id']";
	public static final String AMOUNT_TEXTBOX_AT_SALARY = "//input[@id='salary_basic_salary']";
	public static final String COMMENT_TEXTAREA_AT_SALARY = "//textarea[@id='salary_comments']";
	
	/* Job */
	public static final String JOB_TITLE_DROPDWON_AT_JOB_FORM = "//select[@id='job_job_title']";
	public static final String EMPLOYEE_STATUS_DROPDOWN_AT_JOB_FORM = "//select[@id='job_emp_status']";
	public static final String JOB_CATEGORY_DROPDOWN_AT_JOB_FORM = "//select[@id='job_eeo_category']";
	public static final String JOINED_DATE_DROPDOWN_AT_JOB_FORM = "//input[@id='job_joined_date']";
	public static final String SUB_UNIT_DROPDOWN_AT_JOB_FORM = "//select[@id='job_sub_unit']";
	public static final String SUB_UNIT_CHILD_DROPDOWN_AT_JOB_FORM = "//select[@id='job_sub_unit']/option";
	public static final String LOCATION_DROPDOWN_AT_JOB_FORM = "//select[@id='job_location']";
	
	public static final String START_DATE_TEXTBOX_AT_JOB_FORM = "//input[@id='job_contract_start_date']";
	public static final String END_DATE_TEXTBOX_AT_JOB_FORM = "//input[@id='job_contract_end_date']";
	
	/* Report To */
	public static final String NAME_TEXTBOX_AT_REPORT_TO = "//input[@id='reportto_supervisorName_empName']";
	public static final String REPORTING_METHOD_DROPDOWN_AT_REPORT_TO = "//select[@id='reportto_reportingMethodType']";
	
}
