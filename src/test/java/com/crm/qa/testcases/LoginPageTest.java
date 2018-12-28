/*
 * Author : Kiran Kumar
 */
package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	@Parameters({"browser"})
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service" );
		//Assert.assertEquals(title, "Welcome: Mercury Tours" );
	}

	@Test(priority=2)
	public void crmLogoImageTest(){
		boolean flag = loginPage.validateCRMImage();
		/*WebDriverWait loginSubmitBtn = new WebDriverWait(driver, 10);
		loginSubmitBtn.until(ExpectedConditions.visibilityOf((WebElement) (By.xpath("//button[contains(text(),'Sign Up')]"))));*/
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() throws InterruptedException{
		/*WebDriverWait loginSubmitBtn = new WebDriverWait(driver, 10);
		loginSubmitBtn.until(ExpectedConditions.visibilityOf((WebElement) (By.xpath("//button[contains(text(),'Sign Up')]"))));*/
		Thread.sleep(20);
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
