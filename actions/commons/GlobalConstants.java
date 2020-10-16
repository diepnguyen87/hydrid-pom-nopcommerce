package commons;

public class GlobalConstants {

	public static final String DEV_SERVER = "https://dev.nopcommerce.com/";
	public static final String TESTING_SERVER = "https://demo.nopcommerce.com/";
	public static final String STAGING_SERVER = "https://staging.nopcommerce.com/";
	
	public static final String ROOT_FOLDER = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	
	public static final String DOWNLOAD_FOLDER = ROOT_FOLDER + "/downloadFiles";
	public static final String UPLOAD_FOLDER = ROOT_FOLDER + "/uploadFiles";
	public static final String BROWSER_LOG_FOLDER = ROOT_FOLDER + "/browserLog";
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;
	
}
