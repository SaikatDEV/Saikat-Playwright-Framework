package com.qa.project.base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.project.factory.PlaywrightFactory;
import com.qa.project.pages.HomePage;
import com.qa.project.pages.LoginPage;
import com.qa.project.utilities.ConfigProperties;

public class BaseTest {

	PlaywrightFactory pf;
	Page page;
	
	// All Page references goes here
	protected HomePage homePage;
	protected LoginPage loginPage;
	
	@BeforeTest
	public void setup() {
		pf = new PlaywrightFactory();

		page = pf.initBrowser(ConfigProperties.BROWSER);
		homePage = new HomePage(page);
	}
	
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}
}
