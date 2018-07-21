package ie.murph.sellyourownhome.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SellYourOwnHomeApplicationSeleniumTest {

	public static void main(String[] args) {
		setGeckoDriver();
		initializeMarionetteDriver();
		WebDriver driver = launchFireFoxBrowserDriver();

		successfulLoginCredentials(driver);
		unsuccessfulLoginCredentials(driver);
		closeWebDriver(driver);
	}

	private static void setGeckoDriver() {
		// if you didn't update the Path system variable to add the full directory path
		// to the executable as above mentioned then doing this directly through code
		// System.setProperty("webdriver.gecko.driver", "path/to/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver",
				"C:\\dev\\testing\\selenium\\zip-file\\gecko-driver\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		// System.setProperty("webdriver.gecko.driver",
		// "C:/dev/testing/selenium/zip-file/gecko-driver/geckodriver-v0.21.0-win64/geckodriver.exe");
	}

	private static void initializeMarionetteDriver() {
		// Now you can Initialize marionette driver to launch firefox
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
	}

	private static FirefoxDriver launchFireFoxBrowserDriver() {
		return new FirefoxDriver();
	}

	private static void successfulLoginCredentials(WebDriver driver) {
		launchLoginPage(driver);
		driver.findElement(By.id("username")).sendKeys("lo");
		driver.findElement(By.id("password")).sendKeys("pass");
		clickSubmitButtonOnLoginPage(driver);

		printSuccessfulConnection();
		waitAFewSecondsBeforeClosingSeleniumBrowserWindowTest();
	}

	private static void unsuccessfulLoginCredentials(WebDriver driver) {
		launchLoginPage(driver);
		driver.findElement(By.id("username")).sendKeys("hacker");
		driver.findElement(By.id("password")).sendKeys("password123");
		clickSubmitButtonOnLoginPage(driver);

		printSuccessfulConnection();
		waitAFewSecondsBeforeClosingSeleniumBrowserWindowTest();
	}

	private static void launchLoginPage(WebDriver driver) {
		// Launch the login page
		driver.get("http://localhost:8080/login/index.html");
	}

	private static void clickSubmitButtonOnLoginPage(WebDriver driver) {
		driver.findElement(By.id("btnSubmit")).click();
	}

	private static void printSuccessfulConnection() {
		// Print a Log In message to the screen
		System.out.println("Successfully opened the website localhost");
	}

	private static void waitAFewSecondsBeforeClosingSeleniumBrowserWindowTest() {
		// Wait for 5 Seconds = 5000
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void closeWebDriver(WebDriver driver) {
		driver.quit();
	}

}
