package commons;

import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractTest {
	
	private WebDriver driver;
	
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

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(GlobalConstants.TESTING_SERVER);
		return driver;
	}

	private void setBrowserDriver() {
		if(isWindows()) {
			System.setProperty("webdriver.gecko.driver", GlobalConstants.ROOT_FOLDER + getDirectorySlash("browserDrivers") + "geckodriver.exe");
			System.setProperty("webdriver.chrome.driver", GlobalConstants.ROOT_FOLDER + getDirectorySlash("browserDrivers") + "chromedriver.exe");
			System.setProperty("webdriver.edge.driver", GlobalConstants.ROOT_FOLDER + getDirectorySlash("browserDrivers") + "msedgedriver.exe");
		}else if(isMac()) {
			System.setProperty("webdriver.gecko.driver", GlobalConstants.ROOT_FOLDER + getDirectorySlash("browserDrivers") + "geckodriver_mac");
			System.setProperty("webdriver.chrome.driver", GlobalConstants.ROOT_FOLDER + getDirectorySlash("browserDrivers") + "/chromedriver_mac");
			System.setProperty("webdriver.edge.driver", GlobalConstants.ROOT_FOLDER + getDirectorySlash("browserDrivers") + "/msedgedriver_mac");
		}else {
			System.setProperty("webdriver.gecko.driver", GlobalConstants.ROOT_FOLDER + getDirectorySlash("browserDrivers") + "/geckodriver");
			System.setProperty("webdriver.chrome.driver", GlobalConstants.ROOT_FOLDER + getDirectorySlash("browserDrivers") + "/chromedriver_linux");
		}
	}
	
	
	protected int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}
	
	private String getDirectorySlash(String folderName) {
		if(isMac() || isUnix() || isSolaris()) {
			folderName = "/" + folderName + "/";
		}else {
			folderName = "\\" + folderName + "\\";
		}
		return folderName;
	}
	
	private boolean isWindows() {
		return (GlobalConstants.OS_NAME.toLowerCase().indexOf("win") >= 0);
	}

	private boolean isMac() {
		return (GlobalConstants.OS_NAME.toLowerCase().indexOf("mac") >= 0);
	}

	private boolean isUnix() {
		return (GlobalConstants.OS_NAME.toLowerCase().indexOf("nix") >= 0 || GlobalConstants.OS_NAME.toLowerCase().indexOf("nux") >= 0 || GlobalConstants.OS_NAME.toLowerCase().indexOf("aix") > 0);
	}

	private boolean isSolaris() {
		return (GlobalConstants.OS_NAME.toLowerCase().indexOf("sunos") >= 0);
	}
}
