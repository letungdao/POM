package commons;

import org.testng.annotations.DataProvider;

public class DataProviderFactory {

	@DataProvider(name = "accountTestRisefairketch")
	public static Object[][] dataTest() {
		return new Object[][] { { "admin@demo.com", "riseDemo" }, { "client@demo.com", "riseDemo" } };
	}

}
