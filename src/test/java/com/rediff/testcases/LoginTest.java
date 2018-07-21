package com.rediff.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.framework.exception.SeleniumException;
import com.rediff.pages.HomePage;
import com.rediff.pages.MailPage;
import com.relevantcodes.extentreports.LogStatus;
import com.framework.testtemplate.TestBase;

/**
 * LoginTest.java is test class for login feature test
 * @author Arpit
 *
 */
public class LoginTest extends TestBase {
	
	protected LoginTest() throws SeleniumException {
		super();
		// TODO Auto-generated constructor stub
	}

	MailPage mailPage = null;
	HomePage homePage = null;
		
	@BeforeMethod
	public void LoginTestSetUp(){
		try{
		AppLogs.info("LoginTest->LoginTestSetUp starts..");
		homePage = PageFactory.initElements(driver, HomePage.class);
		mailPage = homePage.openRediffMail();
		AppLogs.info("LoginTestSetUp ends..");
		}catch(Exception e){
			AppLogs.error("LoginTest->LoginTestSetup()"+e);
		}
	}
	
	@Test(dataProvider="readData")
	public void sucessfullLoginTest(Hashtable<String,String> data) throws SeleniumException {
		AppLogs.info("sucessfullLoginTest() starts..");
		test.log(LogStatus.INFO, "sucessfullLoginTest");
		mailPage.doLogin(data.get("Username"), data.get("Password"));
		AppLogs.info("sucessfullLoginTest() ends..");
	}

	@Test(dataProvider="readData")
	public void invalidLoginTest(Hashtable<String,String> data) throws SeleniumException {
		test.log(LogStatus.INFO, "invalidLoginTest");
		mailPage.doLogin(data.get("Username"), data.get("Password"));
		if (mailPage.getErrorMessage().equals(data.get("ErrorMessage"))){
			 test.log(LogStatus.PASS, data.get("ErrorMessage")+ " is displayed");	
		}else{test.log(LogStatus.FAIL, data.get("ErrorMessage")+ " is displayed");}
	}
	
	@Test
	public void verifyUiOnRediffMailPage() throws SeleniumException{
		 //verify page title
		 if (mailPage.getPageTitle().equals("Rediffmail")){
			 test.log(LogStatus.PASS, "Rediff Mail page is displayed, title match");			 
		 }else{test.log(LogStatus.FAIL, "Rediff Mail page is not displayed, did not match");}
		 
		 //Verify User name input field 		 
		 if (mailPage.isClickable(mailPage.Txt_MailPage_User)){
			 test.log(LogStatus.PASS, "Username field is shown");}
		 else{test.log(LogStatus.FAIL, "Username field is not shown");}
		 
		 //Verify Password input field 		 
		 if (mailPage.isClickable(mailPage.Txt_MailPage_Password)){
			 test.log(LogStatus.PASS, "Password field is shown");}
		 else{test.log(LogStatus.FAIL, "Password field is not shown");}
		 
		 //Verify Login button 		 
		 if (mailPage.isClickable(mailPage.Btn_MailPage_Go)){
			 test.log(LogStatus.PASS, "Login button is shown");}
		 else{test.log(LogStatus.FAIL, "Login button is not shown");}
		 
	}
}
