package com.qa.project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.project.base.BaseTest;
import com.qa.project.utilities.AppConstants;

public class LoginPageTest extends BaseTest{
	
	@Test(description = "This test will verify User is Navigated to Login Page", priority = 1)
	public void verifySuccesfullyloadedLoginpage() {
		loginPage = homePage.navigateToLoginPage();
		String loginPageTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(loginPageTitle, AppConstants.LOGIN_PAGE_TITLE);
		boolean linkExist = loginPage.isForgotPasswordLinkExist();
		Assert.assertTrue(linkExist);
	}
	
	@Test(description = "This test will verify User is able to logged in Successfully", priority = 2)
	public void verifySuccesfullyLoggedIn() {
		// verifySuccesfullyloadedLoginpage(); 
		boolean loggedIn = loginPage.doLogin(AppConstants.USERNAME, AppConstants.PASSWORD);
		Assert.assertTrue( loggedIn);
	}
	

}
