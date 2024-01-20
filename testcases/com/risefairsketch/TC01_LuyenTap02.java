package com.risefairsketch;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.DataProviderFactory;
import risefairsketch.HomePage;
import risefairsketch.LoginPage;
import risefairsketch.TasksPage;

public class TC01_LuyenTap02 extends AbstractTest {
	WebDriver driver;
	String uniqueTitle;
	
	@Parameters({"browser"})
	@BeforeMethod
	public void beforeMethod(String browser){
		driver = openMultiBrowsers(browser);
		uniqueTitle = randomEmail();
	}

	@Test(dataProvider = "accountTestRisefairketch", dataProviderClass = DataProviderFactory.class)
	public void TC01_CreateTask(String username, String password) {
		loginPage = new LoginPage(driver);
		
		System.out.println("Step 01 - Login to application");
		loginPage.openLoginPage("https://rise.fairsketch.com/");
		loginPage.loginWithEmailAndPassword(username, password);
		
		homePage = new HomePage(driver);
		System.out.println("VP - Verify Login successfully");
		homePage.verifyHomePageIsDisplayed();
		
		System.out.println("Step 02 - Open page Tasks");
		homePage.selectMenu("tasks");
		
		tasksPage = new TasksPage(driver);
		System.out.println("Step 03 - Click Add task");
		tasksPage.clickAddTask();
		
		System.out.println("Step 04 - Add a new task");
		tasksPage.inputAllInformation(uniqueTitle);
		
		System.out.println("VP - Verify Task is added successfully");
		tasksPage.verifyTaskIsAddedSuccessfully();
	}
	
//	@Test
	public void TC02_SearchAndAdd2Comments(){
		tasksPage = new TasksPage(driver);
		
		System.out.println("Step 01 - Search task");
		tasksPage.searchWithKeyword(uniqueTitle);
		
		System.out.println("Step 02 - Open task info popup");
		tasksPage.clickTaskView();
		
		System.out.println("VP - Verify Task info popup display");
		tasksPage.verifyInfoTaskPopupDisplays();
		
		System.out.println("Step 03 - Add the first comment");
//		tasksPage.addComments("Comment 1");
		
		System.out.println("VP - Verify Comment is added successfully");
//		tasksPage.verifyCommentIsAddedSuccessfully();
		
		System.out.println("Step 04 - Add the second comment");
//		tasksPage.addComments("Comment 2");
		
		System.out.println("VP - Verify Comment is added successfully");
//		tasksPage.verifyCommentIsAddedSuccessfully();
	}
	
	@AfterTest
	public void afterTest(){
		driver.quit();
	}
	
	private LoginPage loginPage;
	private HomePage homePage;
	private TasksPage tasksPage;
}
