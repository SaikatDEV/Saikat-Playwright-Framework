package com.qa.project.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.project.base.BaseTest;
import com.qa.project.utilities.AppConstants;
import com.qa.project.utilities.ConfigProperties;

//@SerenityTest
public class HomePageTest extends BaseTest{
	
	@Test(description = "This test will verify the home page title", priority = 1)
	public void homePageTitleTest() {
		String actualTitle = homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle, AppConstants.HOME_PAGE_TITLE);
	}
	
	@Test(description = "This test will verify the home page URL", priority = 2)
	public void homePageURLTest() {
		String actualURL = homePage.getHomePageURL();
		Assert.assertEquals(actualURL, ConfigProperties.URL);
	}
	
	// Data provider with two dimensional Object array
	@DataProvider
	public Object[][] getproductData(){
		return new Object[][]{
			{"Macbook"},
			{"iMac"},
			{"Samsung"}
		};
	}
	
	@Test(description = "This test will verify the search results", priority = 3, 
			dataProvider = "getproductData")
	public void searchTest(String productName) {
		String actualHeader = homePage.doSearch(productName);
		Assert.assertEquals(actualHeader, "Search - " + productName);
	}
}
