package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import guru99bank.HomePageInterface;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver_){
		driver = driver_;
	}

	public void verifyHomePageIsDisplayed(String user) {
		Assert.assertTrue(driver.findElement(By.xpath(HomePageInterface.marquee)).isDisplayed());
		Assert.assertTrue(
				driver.findElement(By.xpath(String.format(HomePageInterface.TXT_WELCOME, user))).isDisplayed());
	}

}
