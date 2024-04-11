package com.qa.project.utilities;

import org.testng.Assert;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;
import com.qa.project.factory.PlaywrightFactory;
import jline.internal.Log;

public class HelperMethods{
	Page page;
	
		public void click(String locatorKey) {

		try {
			PlaywrightFactory.getPage().locator(OR.getProperty(locatorKey)).click();
			Log.info("Clicking on an Element : " + locatorKey);
			ExtentListeners.getExtent().info("Clicking on an Element : " + locatorKey);
		} catch (Throwable t) {

			Log.error("Error while clicking on an Element : " + t.getMessage());
			ExtentListeners.getExtent()
					.fail("Clicking on an Element : " + locatorKey + " error message is :" + t.getMessage());
			Assert.fail(t.getMessage());
		}
	}

	public boolean isElementPresent(String locatorKey) {

		try {
			PlaywrightFactory.getPage().waitForSelector(OR.getProperty(locatorKey), new WaitForSelectorOptions().setTimeout(2000));

			Log.info("Finding an Element : " + locatorKey);
			ExtentListeners.getExtent().info("Finding an Element : " + locatorKey);
			return true;
		} catch (Throwable t) {

			ExtentListeners.getExtent().fail("Error while finding an Element : " + locatorKey);

			return false;
		}

	}

	public void navigate(String url) {
		PlaywrightFactory.getPage().navigate(url);
		Log.info("Navigated to : " + url);

		PlaywrightFactory.getPage().onDialog(dialog -> {

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			dialog.accept();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Log.info(dialog.message());
		});

	}

}
