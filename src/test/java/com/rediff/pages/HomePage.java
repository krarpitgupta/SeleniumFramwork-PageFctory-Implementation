package com.rediff.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.framework.actions.WebAction;
import com.framework.exception.SeleniumException;

public class HomePage extends WebAction{
	public WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//*[@id='homewrapper']/div[5]/a[1]/div/u")
	public WebElement Lnk_Homepage_Rediffmail;
	
	@FindBy(how = How.ID, using = "srchword")
	public WebElement Txt_HomePage_Search;
	 
	@FindBy(how = How.XPATH, using = "//*[@id='queryTop']/div/input[6]")
	public WebElement Btn_HomePage_Search;
	
	@FindBy(how = How.XPATH, using = "//*[@id='XTIee']")
	public WebElement Lnk_HomePage_Shopping;
	
	@FindBy(how = How.XPATH, using = "//*[@id='homewrapper']/div[5]/a[7]/div/u")
	public WebElement Lnk_ShoppingPage;
	
	@FindBy(how = How.XPATH, using = "//*[@id='productresultsWrapper']")
	public WebElement Tbl_SearchResult;
	
	/**
	 * Purpose : Initialize HomePage object, verifies Login page is opened
	 * @param driver
	 * @throws SeleniumException
	 */
	public HomePage(WebDriver driver) throws SeleniumException {
		super(driver);
		AppLogs.info("HomePage() starts..");
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// Check that we're on the right page.
		if (!driver.getTitle().contains("Rediff")) {
			throw new SeleniumException("This is not the Home page");
		}
		AppLogs.info("HomePage() ends..");
	} 
	
	 public MailPage openRediffMail() throws SeleniumException{
		 AppLogs.info("openRediffMail() starts..");
		 click(Lnk_Homepage_Rediffmail);
		 switchToBrowser("Rediffmail");
		 return PageFactory.initElements(driver, MailPage.class);
	 }
	 
	 
	 public ShoppingPage openShoppingPage() throws SeleniumException{
		 AppLogs.info("openRediffMail() starts..");
		 click(Lnk_ShoppingPage);
		 switchToBrowser("Online Shopping Site India");
		 return PageFactory.initElements(driver, ShoppingPage.class);
	 }
	   
	 /**
		 * Purpose : Set userName in Username edit field
		 * 
		 * @param userName
		 * @throws SeleniumException
		 */
		public void EnterValueInSearchField(String searchName) throws SeleniumException {
			try {
				inputText(Txt_HomePage_Search, searchName);
			} catch (NoSuchElementException e) {
				throw new SeleniumException("LoginPage -> setUserName() - ", e);
			}
		}
		
		public void verifyAllLinkOnHomePage() throws SeleniumException, IOException{
			isLinkBroken();
		}
		
		public void clickOnShopping() throws SeleniumException{
			click(Lnk_HomePage_Shopping);
		}
		
		//entering value in search field
		//Click on Search button
		// verify from search result
		
		
		/**
		 * To verify UI elements on Home Page
		 */
		public void verifyUIElements(){
			isClickable(Txt_HomePage_Search);
			isClickable(Btn_HomePage_Search);
		}
	
		
/*		Use Cases for Search Functionality 
		 - Check if Search option is available on the page.
		 - Check if there is a text box for inserting the search criteria
		 - Check if there is a button along with the text box
		 Check if there is a label 'Search' on the button
		 Check on mouse hover the cursor changes to hand cursor
		 Check if two options 'SHOPPING' and 'BOOKS' are available above the text box
		 Check on hovering mouse cursor changes to hand cursor
		 Check if the two options are exclusively clickable
		  
		Search Functionality for 'SHOPPING' 
		 Search for an available item
		1	Click on the option 'SHOPPING'
		2	Insert a valid shopping item 'tracksuit'
		3	Click on the search button
		4	Matching items visible on the page.
		  
		 Search for an unavailable item
		1	Click on the option 'SHOPPING'
		2	Insert a valid shopping item 'tracksuit'
		3	Click on the search button
		4	Page with a sorry message 'Sorry! We couldn't find anything for sdfgsfdgsdfgsdfg.' is shown
*/		
		
		 
		
}