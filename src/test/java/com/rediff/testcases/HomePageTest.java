package com.rediff.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.framework.exception.SeleniumException;
import com.framework.testtemplate.TestBase;
import com.rediff.pages.HomePage;
import com.rediff.pages.MailPage;
import com.relevantcodes.extentreports.LogStatus;


public class HomePageTest extends TestBase{

	protected HomePageTest() throws SeleniumException {
		super();
	}

	MailPage mailPage = null;
	HomePage homePage = null;
		
	@BeforeMethod
	public void HomePageTestSetUp(){
		try{
		AppLogs.info("HomePageTest->HomePageTestSetUp starts..");
		homePage = PageFactory.initElements(driver, HomePage.class);
		}catch(Exception e){
			new SeleniumException("HomePageTest->HomePageTestSetUp()"+e);
		}
		AppLogs.info("HomePageTest->HomePageTestSetUp ends..");
	}
	
	@Test()
	public void TestBrokenLink() throws SeleniumException, IOException{
		homePage.verifyAllLinkOnHomePage();
	}
	
     /**
     * @throws SeleniumException
      * 
      */
	@Test(dataProvider="readData", description ="To verify search functionality")
	 public void searchText(Hashtable<String,String> data) throws SeleniumException
	 {
		 homePage.EnterValueInSearchField(data.get("search"));
		 homePage.click(homePage.Btn_HomePage_Search);
		 if (homePage.isDisplayed(homePage.Tbl_SearchResult)){
			 test.log(LogStatus.PASS, "Search result is shown");}
		 else{test.log(LogStatus.FAIL, "Search result is not shown");}
	 }
	 
	 @Test
	 public void verifyUIElementsOnHomePage() throws SeleniumException{
		 //verify page title
		 if (homePage.getPageTitle().contains("Rediff")){
			 test.log(LogStatus.PASS, "Home page title match");			 
		 }else{
			 test.log(LogStatus.FAIL, "Home page title did not match");
		 }
		 
		 //Verify rediffmail link 
		 if (homePage.isClickable(homePage.Lnk_Homepage_Rediffmail)){
			 test.log(LogStatus.PASS, "rediffmail link is shown");}
		 else{test.log(LogStatus.FAIL, "rediffmail link is not shown");}
		 
		 //Verify Search input field is shown
		 if (homePage.isClickable(homePage.Txt_HomePage_Search)){
			 test.log(LogStatus.PASS, "Search input field  is shown");}
		 else{test.log(LogStatus.FAIL, "Search input field is not shown");}

		 //Verify Search button 		 
		 if (homePage.isClickable(homePage.Btn_HomePage_Search)){
			 test.log(LogStatus.PASS, "Search button is shown");}
		 else{test.log(LogStatus.FAIL, "Search button is not shown");}
		 
		 //Verify shopping link 
		 if (homePage.isClickable(homePage.Lnk_ShoppingPage)){
			 test.log(LogStatus.PASS, "Shopping page link is shown");}
		 else{test.log(LogStatus.FAIL, "Shopping page link is not shown");}
	 }
 }
