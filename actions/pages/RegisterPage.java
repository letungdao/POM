package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import guru99bank.RegisterPageInterface;

public class RegisterPage extends AbstractPage{
	WebDriver driver;
	
	public RegisterPage(WebDriver driver_){
		driver = driver_;
	}

	public void enterEmailAddress(String email) {
		openUrl(driver, "https://demo.guru99.com");
		sendkeyToElement(driver, RegisterPageInterface.TXB_EMAIL, email);
//		driver.findElement(By.xpath(RegisterPageInterface.TXB_EMAIL)).sendKeys(email);
	}

	public void clickSubmit() {
		clickToElement(driver, RegisterPageInterface.BTN_SUBMIT);
//		driver.findElement(By.xpath(RegisterPageInterface.BTN_SUBMIT)).click();
	}

	public String getUserInfo() {
		return getTextElement(driver, RegisterPageInterface.INFO_USER);
//		return driver.findElement(By.xpath(RegisterPageInterface.INFO_USER)).getText();
	}

	public String getPassInfo() {
		return getTextElement(driver, RegisterPageInterface.INFO_PASS);
//		return driver.findElement(By.xpath(RegisterPageInterface.INFO_PASS)).getText();
	}

}