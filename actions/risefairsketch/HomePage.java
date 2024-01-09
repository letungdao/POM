package risefairsketch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.AbstractPage;

public class HomePage extends AbstractPage {

	WebDriver driver;

	public HomePage(WebDriver driver_) {
		driver = driver_;
	}

	public void verifyHomePageIsDisplayed() {
		Assert.assertTrue(driver.findElement(By.xpath(HomePageInterfaces.TXT_USERNAME)).isDisplayed());
	}

	public void selectMenu(String menu) {
		clickToElement(driver, String.format(HomePageInterfaces.TXT_MENU, menu));
	}

}
