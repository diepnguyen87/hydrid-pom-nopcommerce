package commons;

import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractTest {
	
	private WebDriver driver;
	protected final Log log;
	
	public AbstractTest() {
		log = LogFactory.getLog(getClass());
	}
	
	protected WebDriver getBrowserDriver(String browserName) {
		Browser browser = Browser.valueOf(browserName.toUpperCase());
		
		if (browser == Browser.FIREFOX_UI) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser == Browser.CHROME_UI) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("useAutomationExtension", false);
			chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			driver = new ChromeDriver(chromeOptions);
		} else if (browser == Browser.FIREFOX_HEADLESS) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(true);
			driver = new FirefoxDriver(options);
		} else if (browser == Browser.CHROME_HEADLESS) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
		} else if (browser == Browser.EDGE_CHROMIUM) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else if (browser == Browser.IE_UI) {
			WebDriverManager.iedriver().arch32().setup();
			driver = new InternetExplorerDriver();
		}else {
			throw new RuntimeException("Please input valid browser name value!");
		}

		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(GlobalConstants.TESTING_SERVER);
		return driver;
	}
	
	protected WebDriver getBrowserDriver(String browserName, String webURL) {
		
		Browser browser = Browser.valueOf(browserName.toUpperCase());
		
		if (browser == Browser.FIREFOX_UI) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser == Browser.CHROME_UI) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("useAutomationExtension", false);
			chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			driver = new ChromeDriver(chromeOptions);
		} else if (browser == Browser.FIREFOX_HEADLESS) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(true);
			driver = new FirefoxDriver(options);
		} else if (browser == Browser.CHROME_HEADLESS) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
		} else if (browser == Browser.EDGE_CHROMIUM) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else if (browser == Browser.IE_UI) {
			WebDriverManager.iedriver().arch32().setup();
			driver = new InternetExplorerDriver();
		}else {
			throw new RuntimeException("Please input valid browser name value!");
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(webURL);
		return driver;
	}

	private void setBrowserDriver() {
		if(GlobalConstants.isWindows()) {
			System.setProperty("webdriver.gecko.driver", GlobalConstants.ROOT_FOLDER + GlobalConstants.getDirectorySlash("browserDrivers") + "geckodriver.exe");
			System.setProperty("webdriver.chrome.driver", GlobalConstants.ROOT_FOLDER + GlobalConstants.getDirectorySlash("browserDrivers") + "chromedriver.exe");
			System.setProperty("webdriver.edge.driver", GlobalConstants.ROOT_FOLDER + GlobalConstants.getDirectorySlash("browserDrivers") + "msedgedriver.exe");
		}else if(GlobalConstants.isMac()) {
			System.setProperty("webdriver.gecko.driver", GlobalConstants.ROOT_FOLDER + GlobalConstants.getDirectorySlash("browserDrivers") + "geckodriver_mac");
			System.setProperty("webdriver.chrome.driver", GlobalConstants.ROOT_FOLDER + GlobalConstants.getDirectorySlash("browserDrivers") + "/chromedriver_mac");
			System.setProperty("webdriver.edge.driver", GlobalConstants.ROOT_FOLDER + GlobalConstants.getDirectorySlash("browserDrivers") + "/msedgedriver_mac");
		}else {
			System.setProperty("webdriver.gecko.driver", GlobalConstants.ROOT_FOLDER + GlobalConstants.getDirectorySlash("browserDrivers") + "/geckodriver");
			System.setProperty("webdriver.chrome.driver", GlobalConstants.ROOT_FOLDER + GlobalConstants.getDirectorySlash("browserDrivers") + "/chromedriver_linux");
		}
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	protected int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}
	
	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add loi vao ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}
}
