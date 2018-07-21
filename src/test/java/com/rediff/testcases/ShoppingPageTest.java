package com.rediff.testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.framework.exception.SeleniumException;
import com.framework.testtemplate.TestBase;
import com.rediff.pages.HomePage;
import com.rediff.pages.ShoppingPage;
import com.relevantcodes.extentreports.LogStatus;

import mx4j.log.Logger;

public class ShoppingPageTest extends TestBase{

	 protected ShoppingPageTest() throws SeleniumException {
	 	super();
	 	 
	 }
	 HomePage homePage = null;
	 ShoppingPage shoppingPage = null; 
	 	
	 @BeforeMethod
	 public void LoginTestSetUp(){
	 	try{
	 	AppLogs.info("LoginTestSetUp starts..");
	 	homePage = PageFactory.initElements(driver, HomePage.class);
	 	shoppingPage = homePage.openShoppingPage(); 
	 	AppLogs.info("LoginTestSetUp ends..");
	 	}catch(Exception e){
	 	AppLogs.error("LoginTestSetup()"+e);
	 	}	 
	 }
	 /**
	  * 
	  * @throws SeleniumException
	  */
	 @Test
	 public void clickOnMenLifeStyleTest() throws SeleniumException
	 {
		 test.log(LogStatus.INFO, "clickOnMenLifeStyleTest");
		 shoppingPage.clickOnMenLifeStyle();

		 //Verify Mens's life page is open
		 if (shoppingPage.isClickable(shoppingPage.Lnk_ShoppingPage_menLifestyle)){
			 test.log(LogStatus.PASS, "Men's life stype page is open");}else
		 {test.log(LogStatus.FAIL, "Men's life stype page is not displayed"); }
		 shoppingPage.click(shoppingPage.Lnk_ShoppingPage_SMmensFootWear);
	 }
	 
	 @Test
	 public void verifyUiOnShoppingPage() throws SeleniumException{
		 //verify page title
		 if (shoppingPage.getPageTitle().contains("Rediff Shopping")){
			 test.log(LogStatus.PASS, "Rediff Shopping page is displayed, title match");			 
		 }else{test.log(LogStatus.FAIL, "Rediff Shoping page is not displayed, title did not match");}
		 
		 //Verify Shopping Search field is shown 		 
		 if (shoppingPage.isClickable(shoppingPage.Txt_ShoppingPage_Search)){
			 test.log(LogStatus.PASS, "Login button is shown");}
		 else{test.log(LogStatus.FAIL, "Login button is not shown");}

		//Verify Shopping Search field is shown 		 
		 if (shoppingPage.isClickable(shoppingPage.Lnk_ShoppingPage_menLifestyle)){
			 test.log(LogStatus.PASS, "Men's Life Style tab is shown");}
		 else{test.log(LogStatus.FAIL, "Men's Life Style tab is not shown");}
		 
		//Verify Shopping Search field is shown 		 
		 if (shoppingPage.isClickable(shoppingPage.Lnk_ShoppingPage_WomenLifestyle)){
			 test.log(LogStatus.PASS, "Women Lifestyle tab is shown");}
		 else{test.log(LogStatus.FAIL, "Women Lifestyle tab is not shown");}
		 
		//Verify Shopping Search field is shown 		 
		 if (shoppingPage.isClickable(shoppingPage.Lnk_ShoppingPage_Mobiles)){
			 test.log(LogStatus.PASS, "Mobile tab is shown");}
		 else{test.log(LogStatus.FAIL, "Mobile tab is not shown");}
		 
		//Verify Shopping Search field is shown 		 
		 if (shoppingPage.isClickable(shoppingPage.Txt_ShoppingPage_SearchBrand)){
			 test.log(LogStatus.PASS, "Search Branch tab is shown");}
		 else{test.log(LogStatus.FAIL, "Search Branch tab is not shown");}
		 
			//Verify Shopping Search field is shown 		 
		 if (shoppingPage.isClickable(shoppingPage.Lnk_ShoppingPage_SMWomensHandbags)){
			 test.log(LogStatus.PASS, "Women Handbags tab is shown");}
		 else{test.log(LogStatus.FAIL, "Women Handbags tab is not shown");}

		 
			//Verify Shopping Search field is shown 		 
		 if (shoppingPage.isClickable(shoppingPage.Lnk_ShoppingPage_SMmensFootWear)){
			 test.log(LogStatus.PASS, "Men FootWear tab is shown");}
		 else{test.log(LogStatus.FAIL, "Men FootWear tab is not shown");}

		//Verify Shopping Search field is shown 		 
		 if (shoppingPage.isClickable(shoppingPage.Lnk_ShoppingPage_Bluetooth_Headsets)){
			 test.log(LogStatus.PASS, "Bluetooth tab is shown");}
		 else{test.log(LogStatus.FAIL, "Bluetooth tab is not shown");}


	
	 }
}