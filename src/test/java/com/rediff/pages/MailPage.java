package com.rediff.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.framework.actions.WebAction;
import com.framework.exception.SeleniumException;

public class MailPage extends WebAction{
	
public WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//*[@id='login1']")
	public WebElement Txt_MailPage_User;
	
	@FindBy(how = How.XPATH, using = "//*[@id='password']")
	public WebElement Txt_MailPage_Password;
	
	@FindBy(how = How.XPATH, using = "//*[@name='proceed']")
	public WebElement Btn_MailPage_Go;
	
	@FindBy(how = How.XPATH, using = "//*[@id='login']/div[2]/div[2]/div[4]/div")
	private WebElement Lbl_MailPage_LoginError;
	
	
	/**
	 * Purpose : Initialize MailPage object
	 * @param driver
	 * @throws SeleniumException
	 */
	
	public MailPage(WebDriver driver) {
		super(driver);
		AppLogs.info("MailPage() starts.."+driver.getWindowHandle()+" , "+driver.getCurrentUrl());
		this.driver = driver;
		PageFactory.initElements(driver, this);
		AppLogs.info("MailPage() ends..");
	} 
	
	/**
	 * Purpose : Click on Log In button
	 * @throws SeleniumException
	 */
	public void clickLogin() throws SeleniumException {
		AppLogs.info("LoginPage -> clickLogin() starts..");
		try {
			click(Btn_MailPage_Go);
		} catch (NoSuchElementException e) {
			throw new SeleniumException("LoginPage -> clickLogin() - ", e);
		}
		AppLogs.info("clickLogin() ends..");
	}

	/**
	 * Purpose : Set userName in Username edit field
	 * @param userName
	 * @throws SeleniumException
	 */
	public void setUserName(String userName) throws SeleniumException {
		try {
			inputText(Txt_MailPage_User, userName);
		} catch (NoSuchElementException e) {
			throw new SeleniumException("LoginPage -> setUserName() - ", e);
		}
	}

	/**
	 * Purpose : set password in Password Edit field
	 * @param password
	 * @throws SeleniumException
	 */
	public void setPassword(String password) throws SeleniumException {
		try {
			inputText(Txt_MailPage_Password, password);
		} catch (NoSuchElementException e) {
			throw new SeleniumException("LoginPage -> setPassword() - ", e);
		}
	}
	
	public String getErrorMessage() throws SeleniumException {
		return getText(Lbl_MailPage_LoginError);
	}
	
	// Buisness Flow
	/**
	 * Purpose : do login into website
	 * 
	 * @param userName
	 * @param Password
	 * @throws SeleniumException
	 */
	public void doLogin(String userName, String Password) throws SeleniumException {
		setUserName(userName);
		setPassword(Password);
		clickLogin();
	}
}
