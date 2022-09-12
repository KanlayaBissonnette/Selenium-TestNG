package Utilities;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	private static WebDriver driver;

	public static WebDriver getDriver() {

		if (driver == null) {
			switch (Constants.BROWSER) {

			case "Chrome":
				WebDriverManager.chromedriver().setup();
				// INIT CHROME OPTIONS
				ChromeOptions options = new ChromeOptions();
				Map<String, Object> prefs = new HashMap<String, Object>();
				Map<String, Object> profile = new HashMap<String, Object>();
				Map<String, Object> contentSettings = new HashMap<String, Object>();

				// SET CHROME OPTIONS
				// 0 - Default, 1 - Allow, 2 - Block
				contentSettings.put("notifications", 2);
				profile.put("managed_default_content_settings", contentSettings);
				prefs.put("profile", profile);
				options.setExperimentalOption("prefs", prefs);
				driver = new ChromeDriver(options);
				break;

			case "safari":
				// WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				break;

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}

			driver.get(Constants.URL);
			setUpWindow();
			Pageinitialized.init();

		}

		return driver;
	}

	public static void setUpWindow() {
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	public void tearDown() {
		if (driver != null) {
			driver.close();
			driver = null;
		}
	}

}
