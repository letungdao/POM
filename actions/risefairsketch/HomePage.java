package risefairsketch;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class HomePage extends AbstractPage {

	WebDriver driver;

	public HomePage(WebDriver driver_) {
		driver = driver_;
	}

	public void verifyHomePageIsDisplayed() {
		// verifyPassed(isElementDispalyed(driver,
		// HomePageInterfaces.TXT_USERNAME), "Home page is displayed", "HomePage
		// is NOT displayed");
		String actualTitle = getTitle(driver);
		String expectedTitle = "HomePage";
		verifyEqual(actualTitle, expectedTitle, "Home Page is displayed", "Home Page is NOT displayed");
	}

	public void selectMenu(String menu) {
		clickToElement(driver, String.format(HomePageInterfaces.TXT_MENU, menu));
	}

}
