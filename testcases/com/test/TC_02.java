package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;

public class TC_02 extends AbstractTest {

	private WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) throws Exception {
		driver = getBrowserDriver(browserName, "http://agiletesters.com.br");
	}

	@Test
	public void SalvarImagemFileOnSite() {
		System.out.println("test");
	}
	
	@AfterClass
	public void afterClass() {
	}

}
