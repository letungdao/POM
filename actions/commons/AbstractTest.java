package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.openqa.jetty.log.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;


import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class AbstractTest {

	WebDriver driver;

	protected final Log log;

	protected AbstractTest() {
		log = LogFactory.getLog(getClass());
	}

	public WebDriver openMultiBrowsers(String browser, String version) {
		if (browser.equalsIgnoreCase("chrome")) {
			// System.setProperty("webdriver.chrome.driver",
			// ".\\resources\\chromedriver.exe");
			ChromeDriverManager.getInstance().version(version).setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			// System.setProperty("webdriver.gecko.driver",
			// ".\\resources\\geckodriver.exe");
			FirefoxDriverManager.getInstance().version(version).setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chromeheadless")) {
			// System.setProperty("webdriver.chrome.driver",
			// ".\\resources\\chromedriver.exe");
			ChromeDriverManager.getInstance().version(version).setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1400,800");
			log.info("-----------Open chrome browser------------");
			driver = new ChromeDriver(options);
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public boolean verifyPassed(boolean condition, String messagePass, String messageFail) {
		boolean result = true;
		try {
			if (condition == true) {
				System.out.println(messagePass);
			} else {
				System.out.println(messageFail);
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			result = false;
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return result;
	}

	public boolean verifyFailed(boolean condition, String messagePass, String messageFail) {
		boolean result = true;
		try {
			if (condition == false) {
				System.out.println(messagePass);
			} else {
				System.out.println(messageFail);
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			result = false;
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return result;
	}

	public boolean verifyEqual(Object actual, Object expected, String messagePass, String messageFail) {
		boolean result = true;
		try {
			if (actual.equals(expected)) {
				System.out.println(messagePass);
			} else {
				System.out.println(messageFail);
			}
			Assert.assertEquals(actual, expected);
		} catch (Throwable e) {
			result = false;
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return result;
	}

	public String randomEmail() {
		Random random = new Random();
		int number = random.nextInt(999999);
		String randomEmail = "automation" + number + "@gmail.com";
		return randomEmail;
	}
}
