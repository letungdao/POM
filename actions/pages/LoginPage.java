package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import guru99bank.LoginPageInterface;

public class LoginPage extends AbstractPage{
	WebDriver driver;

	public LoginPage(WebDriver driver_){
		driver = driver_;
	}
	
	public void openLoginPage(String url){
		openUrl(driver, url);
	}
	public void clickHere() {
		clickToElement(driver, LoginPageInterface.HERE_LINK);
//		driver.findElement(By.xpath(LoginPageInterface.HERE_LINK)).click();
	}
	
	public void inputUserIdAndPassword(String user, String password){
		sendkeyToElement(driver, LoginPageInterface.TXB_USER, user);
		sendkeyToElement(driver, LoginPageInterface.TXB_PASSWORD, password);
//		driver.findElement(By.xpath(LoginPageInterface.TXB_USER)).sendKeys(user);
//		driver.findElement(By.xpath(LoginPageInterface.TXB_PASSWORD)).sendKeys(password);
	}
	
	public void clickLogin(){
		clickToElement(driver, LoginPageInterface.BTN_LOGIN);
//		driver.findElement(By.xpath(LoginPageInterface.BTN_LOGIN)).click();
	}

}
