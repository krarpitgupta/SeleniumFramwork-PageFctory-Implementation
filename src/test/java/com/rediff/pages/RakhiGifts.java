package com.rediff.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.framework.actions.WebAction;
import com.framework.exception.SeleniumException;

public class RakhiGifts extends WebAction{

	public WebDriver driver;

	@FindBy(how = How.ID, using = "srchword")
	public WebElement Txt_RakhiGiftsPage_Search;

	@FindBy(how = How.LINK_TEXT, using = "Sign In")
	public WebElement Lnk_RakhiGiftsPage_SignIn;

	@FindBy(how = How.LINK_TEXT, using = "Sign Up")
	public WebElement Lnk_RakhiGiftsPage_SignUp;

	@FindBy(how = How.XPATH, using = "//*[@id='order_status_link']/span")
	public WebElement Lnk_RakhiGiftsPage_TrackOrder;

	@FindBy(how = How.XPATH, using = "//*[@id='topcartmob']/span")
	public WebElement Lnk_RakhiGiftsPage_YourCart;

	HomePage homePage = PageFactory.initElements(driver, HomePage.class); 
			
	
	public RakhiGifts(WebDriver driver) throws SeleniumException {
		super(driver);
		AppLogs.info("RakhiGiftsPage() starts..");
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// Check that we're on the right page.
		if (!driver.getTitle().contains("******")) {
			throw new SeleniumException("This is not the RakhiGifts page");
		}
		AppLogs.info("RakhiGiftsPage() ends..");
	}

	public void EnterValueInSearchField(String searchName) throws SeleniumException {
		try {
			homePage.EnterValueInSearchField(searchName);
		//	inputText(Txt_RakhiGiftsPage_Search, searchName);
		} catch (NoSuchElementException e) {
			throw new SeleniumException("No Search - ", e);
		}
	}
}
