package com.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;

public class TC_01 extends AbstractTest {

	private WebDriver driver;
	private String projectURL = System.getProperty("user.dir");

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) throws Exception {
		driver = getBrowserDriver(browserName);

		//System.setProperty("webdriver.chrome.driver", projectURL + "/browserDrivers/chromedriver1.exe");
		//driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.get("https://www.google.com/");
		
	}

	public void f() {
		WebElement element = driver.findElement(By.xpath("//img[@id='hplogo']"));
		// WebElement searchElement =
		// driver.findElement(By.xpath("//input[@name='q']"));

		Actions action = new Actions(driver);

		action.contextClick(element).sendKeys(Keys.SHIFT, "v").perform();

		// action.sendKeys(Keys.CONTROL, "s").perform();
	}

	@Test
	public void SalvarImagemFileOnSite() {
		System.out.println("test");
		/*
		 * try { //driver.get("http://agiletesters.com.br"); Thread.sleep(2000);
		 * WebElement logo =
		 * driver.findElement(By.xpath("//img[contains(@alt, 'episode')]")); String
		 * logoSRC = logo.getAttribute("src"); System.out.println("logo src:" +
		 * logoSRC);
		 * 
		 * URL imageURL = new URL(logoSRC); BufferedImage saveImage =
		 * ImageIO.read(imageURL);
		 * 
		 * ImageIO.write(saveImage, "png", new File(projectURL + "\\episode.png"));
		 * 
		 * } catch (Exception e) { e.printStackTrace(); } finally { driver.close(); }
		 */
	}

	@AfterClass
	public void afterClass() {
		// driver.close();
	}

}
