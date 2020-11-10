package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;

public class TC_01 extends AbstractTest {

	private WebDriver driver;
	private String projectURL = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass(){
		System.setProperty("webdriver.chrome.driver", projectURL + "/browserDrivers/chromedriver1.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://calc.tma.com.vn/bzghkeedo2vj");
		
	}

	@Test
	public void f() {
		
		driver.findElement(By.xpath("//td[@id='cell_B14']//p")).sendKeys("abc");
		
		
	}

	@AfterClass
	public void afterClass() {
		// driver.close();
	}

}
