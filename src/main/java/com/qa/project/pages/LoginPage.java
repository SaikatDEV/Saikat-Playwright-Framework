package com.qa.project.pages;

import com.microsoft.playwright.Page;
import jline.internal.Log;

public class LoginPage {
	private Page page;

    //	PAGE LOCATORs are located Here
    //	*********************************ICONs[icn]*******************************

    //	*********************************HEADERs[hdr]******************************

    //	*********************************CONTAINERs[ctn]***************************

    //	*********************************MENUs[mnu]********************************

    //	*********************************CHECKBOXes[chk]***************************

    //	*********************************FIELDs[fld]*******************************
    private String fld_Email = "//input[@id='input-email']"; 
    private String fld_Password = "//input[@id='input-password']"; 
    private String fld_Forgotten_Password = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']";
    //	*********************************TEXTFIELDs[txt]***************************

    //	*********************************BUTTONs[btn]******************************
    private String btn_Login = "//input[@value='Login']";
    private String btn_LogOut = "//a[@class='list-group-item'][normalize-space()='Logout']";
    //	*********************************LINKs[lnk]********************************

    //	*********************************FORMs[frm]********************************

    //	*********************************DDLs[ddl]*********************************

	//	*********************************Page Constructor**************************
	public LoginPage(Page page) {
		this.page = page;		
	}
	
	//	*************************Navigate to the next Page*************************
	public AccountPage navigateToAccountPage(){
	// page.click(lnk_Login);
		
		return new AccountPage();
	}
	//	*********************************Page Actions*****************************	
    public String getLoginPageTitle(){
	    String pageTitle =  page.title();
	    Log.info("Login Page title is: " + pageTitle.trim());
	    return pageTitle;
	}
	
	public boolean isForgotPasswordLinkExist(){
		page.waitForSelector(fld_Forgotten_Password);
	    boolean isVisible =  page.isVisible(fld_Forgotten_Password);
	    Log.info("Forgotten Password is Visible: " + isVisible);
	    return isVisible;
	}
	
	public boolean doLogin(String appUserName, String appPassword){
	    Log.info("User Name: " + appUserName + ", Password: " + appPassword);
	    page.fill(fld_Email, appUserName);
	    page.fill(fld_Password, appPassword);
	    page.click(btn_Login);
	    Log.info("User has been clicked on Login Button");
	    
	    if(page.isVisible(btn_LogOut)){
	    Log.info("User has been logged in");
	        return true;
	    }
	    Log.info("User was not logged in");
	    return false;
	}
}
