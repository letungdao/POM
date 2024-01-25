package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.AbstractPage;
import guru99bank.HomePageInterface;

public class HomePage extends AbstractPage{
	WebDriver driver;
	
	public HomePage(WebDriver driver_){
		driver = driver_;
	}

	public void verifyHomePageIsDisplayed(String user) {
		verifyPassed(isElementDispalyed(driver, HomePageInterface.marquee), "Marquee is displayed", "Marquee is NOT displayed");
		verifyPassed(isElementDispalyed(driver, String.format(HomePageInterface.TXT_WELCOME, user)), "Text welcome is dispalyed", "Text welcome is NOT dispalyed");
	}

}
