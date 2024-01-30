package com.risefairsketch;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
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
	
	@Parameters({"browser", "version"})
	@BeforeMethod
	public void beforeMethod(String browser, String version){
		driver = openMultiBrowsers(browser, version);
		uniqueTitle = randomEmail();
	}

	@Test(dataProvider = "accountTestRisefairketch", dataProviderClass = DataProviderFactory.class)
	public void TC01_CreateTask(String username, String password) {
		loginPage = new LoginPage(driver);
		
		log.info("Step 01 - Open rise fairsketch page");
		loginPage.openLoginPage("https://rise.fairsketch.com/");

		log.info("Step 02 - Login with username " +username);
		loginPage.loginWithEmailAndPassword(username, password);
		
		homePage = new HomePage(driver);
		log.info("VP - Verify Login successfully");
		homePage.verifyHomePageIsDisplayed();
		
		log.info("Step 02 - Open page Tasks");
		homePage.selectMenu("tasks");
		
		tasksPage = new TasksPage(driver);
		log.info("Step 03 - Click Add task");
		tasksPage.clickAddTask();
		
		log.info("Step 04 - Add a new task");
		tasksPage.inputAllInformation(uniqueTitle);
		
		log.info("VP - Verify Task is added successfully");
		tasksPage.verifyTaskIsAddedSuccessfully();
	}
	
//	@Test
	public void TC02_SearchAndAdd2Comments(){
		tasksPage = new TasksPage(driver);
		
		log.info("Step 01 - Search task");
		tasksPage.searchWithKeyword(uniqueTitle);
		
		log.info("Step 02 - Open task info popup");
		tasksPage.clickTaskView();
		
		log.info("VP - Verify Task info popup display");
		tasksPage.verifyInfoTaskPopupDisplays();
		
		log.info("Step 03 - Add the first comment");
//		tasksPage.addComments("Comment 1");
		
		log.info("VP - Verify Comment is added successfully");
//		tasksPage.verifyCommentIsAddedSuccessfully();
		
		log.info("Step 04 - Add the second comment");
//		tasksPage.addComments("Comment 2");
		
		log.info("VP - Verify Comment is added successfully");
//		tasksPage.verifyCommentIsAddedSuccessfully();
	}
	
	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}
	
	private LoginPage loginPage;
	private HomePage homePage;
	private TasksPage tasksPage;
}
