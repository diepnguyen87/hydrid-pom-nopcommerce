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

public class AbstractTest {
	
	private WebDriver driver;
	private String webURL = "https://demo.nopcommerce.com/";
	private String projectURL = System.getProperty("user.dir");
	
	public WebDriver getBrowserDriver(String browserName) {
		if (browserName.equals("firefox_ui")) {
			System.setProperty("webdriver.gecko.driver", projectURL + "/browserDrivers/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("chrome_ui")) {
			System.setProperty("webdriver.chrome.driver", projectURL + "/browserDrivers/chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("useAutomationExtension", false);
			chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			driver = new ChromeDriver(chromeOptions);
		} else if (browserName.equals("firefox_headless")) {
			System.setProperty("webdriver.gecko.driver", projectURL + "/browserDrivers/geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(true);
			driver = new FirefoxDriver(options);
		} else if (browserName.equals("chrome_headless")) {
			System.setProperty("webdriver.chrome.driver", projectURL + "/browserDrivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
		} else if (browserName.equals("edge_chromium")) {
			System.setProperty("webdriver.edge.driver", projectURL + "/browserDrivers/msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Please input valid browser name value!");
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(webURL);
		return driver;
	}

	protected int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}
	
}
