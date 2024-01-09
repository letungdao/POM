package com.risefairsketch;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import risefairsketch.HomePage;
import risefairsketch.LoginPage;
import risefairsketch.TasksPage;

public class TC01_LuyenTap02 extends AbstractTest {
	WebDriver driver;
	String uniqueTitle;
	
	@Parameters({"browser"})
	@BeforeTest
	public void beforeTest(String browser){
		driver = openMultiBrowsers(browser);
		uniqueTitle = randomEmail();
	}

	@Test
	public void TC01_CreateTask() {
		loginPage = new LoginPage(driver);
		loginPage.openLoginPage("https://rise.fairsketch.com/");
		loginPage.loginWithEmailAndPassword("admin@demo.com", "riseDemo");
		
		homePage = new HomePage(driver);
		homePage.verifyHomePageIsDisplayed();
		homePage.selectMenu("tasks");
		
		tasksPage = new TasksPage(driver);
		tasksPage.clickAddTask();
		tasksPage.inputAllInformation(uniqueTitle);
		tasksPage.verifyTaskIsAddedSuccessfully();
	}
	
	@Test
	public void TC02_SearchAndAdd2Comments(){
		tasksPage = new TasksPage(driver);
		tasksPage.searchWithKeyword(uniqueTitle);
		tasksPage.clickTaskView();
		tasksPage.verifyInfoTaskPopupDisplays();
	}
	
	@AfterTest
	public void afterTest(){
//		driver.quit();
	}
	
	private LoginPage loginPage;
	private HomePage homePage;
	private TasksPage tasksPage;
}
