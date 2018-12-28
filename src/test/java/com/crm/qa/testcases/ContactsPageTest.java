package com.crm.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName = "contacts";
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	
	@Test(priority=1)
	public void verifyContactsPageLabelTest(){
		Assert.assertTrue(contactsPage.verifyContactsLabel());
	}
	
	
	@Test(priority=2)
	public void selectContactsTest(){
		contactsPage.selectContactsByName("Mayur Kiran");
	}
	
	@Test(priority=3)
	public void unSelectContactsTest(){
		contactsPage.selectContactsByName("Mayur Kiran");
		contactsPage.selectContactsByName("Mayur Kiran");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() throws InvalidFormatException{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstname, String lastname, String company)
	{
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact(title, firstname, lastname, company);
	}
	
	/*@Test(priority=4)
	public void validateCreateNewContact(){
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact("Mr.", "Mayur", "Kiran", "Google");
	}*/
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
