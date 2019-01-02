package com.crm.qa.testcases;

//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class TasksPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	TasksPage tasksPage;
		
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil = new TestUtil();
		tasksPage = new TasksPage();
		testUtil.switchToFrame();
		tasksPage = homePage.clickOnTasksLink();
	}
	
	
	@Test(priority=1)
	public void verifyTasksPageLabelTest(){
		Assert.assertTrue(tasksPage.verifyTasksLabel());
	}
	
		
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
