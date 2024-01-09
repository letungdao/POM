package risefairsketch;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class LoginPage extends AbstractPage {
	WebDriver driver;

	public LoginPage(WebDriver driver_) {
		driver = driver_;
	}
	
	public void openLoginPage(String url){
		openUrl(driver, url);
	}

	public void loginWithEmailAndPassword(String email, String password) {
		clearText(driver, LoginPageInterfaces.TXB_EMAIL);
		sendkeyToElement(driver, LoginPageInterfaces.TXB_EMAIL, email);
		clearText(driver, LoginPageInterfaces.TXB_PASSWORD);
		sendkeyToElement(driver, LoginPageInterfaces.TXB_PASSWORD, password);
		clickToElement(driver, LoginPageInterfaces.BTN_SIGNIN);
	}

}
