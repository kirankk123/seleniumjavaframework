package com.crm.qa.pages;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class TasksPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(), 'Tasks')]")
	WebElement tasksLabel;
	
	/*@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveContactBtn;*/
	
	
	public TasksPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean verifyTasksLabel(){
		return tasksLabel.isDisplayed();
	}
	
	/*public void selectContactsByName(String name){
		driver.findElement(By.xpath("//a[text()='"+name+"']//..//..//input[@name='contact_id']")).click();
	}

	public void createNewContact(String title, String FName, String LName, String CompanyName){
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstName.sendKeys(FName);
		lastName.sendKeys(LName);
		company.sendKeys(CompanyName);
		
		saveContactBtn.click();
	}*/

}
