package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	// Page Factory - OR
	@FindBy(name="username")
	WebElement username;
		
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	@FindBy(xpath="intercom-block intercom-block-paragraph")
	WebElement crmChatPopUpMouseMove;
	
	@FindBy(xpath="//div[@class='intercom-borderless-dismiss-button']/span")
	WebElement crmChatPopUpClose;
	
	
	//
	//@FindBy(name="userName")
	//WebElement username;
	//
	//@FindBy(name="password")
	//WebElement password;
	//
	//@FindBy(name="login")
	//WebElement loginBtn;
	
	//@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	//WebElement sighUpBtn;
	
	//@FindBy(xpath="//img[contains(@src,'/images/nav/logo.gif')]")
	//WebElement crmLogo;
	
	
	
	
	
	//Initializing the Page Objects
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public void closeChatPopUpWindow(){
		driver.switchTo().frame("intercom-borderless-frame");
		crmChatPopUpClose.click();
		driver.switchTo().defaultContent();
	}
	
	public boolean validateCRMImage(){
		closeChatPopUpWindow();
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd){
		closeChatPopUpWindow();
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
}
