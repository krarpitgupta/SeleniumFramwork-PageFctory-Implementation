package com.rediff.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.framework.actions.WebAction;
import com.framework.exception.SeleniumException;

import mx4j.log.Logger;

public class ShoppingPage extends WebAction {

	public WebDriver driver;

	@FindBy(how = How.ID, using = "srchword")
	public WebElement Txt_ShoppingPage_Search;

	@FindBy(how = How.ID, using = "topcat1")
	public WebElement Lnk_ShoppingPage_menLifestyle;

	@FindBy(how = How.ID, using = "topcat2")
	public WebElement Lnk_ShoppingPage_WomenLifestyle;

	@FindBy(how = How.ID, using = "topcat3")
	public WebElement Lnk_ShoppingPage_Mobiles;

	@FindBy(how = How.ID, using = "searchbrand")
	public WebElement Txt_ShoppingPage_SearchBrand;

	@FindBy(how = How.XPATH, using = "//*[@id='div_subcatrgory']/div[1]/a[2]")
	public WebElement Lnk_ShoppingPage_Bluetooth_Headsets;

	@FindBy(how = How.XPATH, using = "//*[@id='div_subcatrgory']/div[1]/a[3]")
	public WebElement Lnk_ShoppingPage_SMmensFootWear;

	@FindBy(how = How.XPATH, using = "//*[@id='div_subcatrgory']/div[1]/a[5]")
	public WebElement Lnk_ShoppingPage_SMWomensHandbags;

	HomePage homePage = null;

	public ShoppingPage(WebDriver driver) throws SeleniumException {
		super(driver);
		AppLogs.info("ShoppingPage() starts..");
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// Check that we're on the right page.
		if (!driver.getTitle().contains("Rediff Shopping")) {
			throw new SeleniumException("This is not the Shopping page");
		}
	}
    
	/**
	 * @throws SeleniumException 
	 * 
	 */
	public void clickOnMenLifeStyle() throws SeleniumException {
		moveToElement(Lnk_ShoppingPage_menLifestyle);
		click(Lnk_ShoppingPage_SMmensFootWear);
	}

	public void clickOnWomenLifeStyle() throws SeleniumException {
		moveToElement(Lnk_ShoppingPage_WomenLifestyle);
		click(Lnk_ShoppingPage_SMWomensHandbags);
		
		if (isClickable(Lnk_ShoppingPage_SMWomensHandbags)){
			System.out.println("Woman hands bag is open");
		}
	}
   
	public void clickOnMobiles() throws SeleniumException {
		moveToElement(Lnk_ShoppingPage_Mobiles);
		click(Lnk_ShoppingPage_Bluetooth_Headsets);
	}
}