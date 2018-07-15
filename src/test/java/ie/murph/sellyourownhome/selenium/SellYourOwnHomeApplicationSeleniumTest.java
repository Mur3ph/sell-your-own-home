package ie.murph.sellyourownhome.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SellYourOwnHomeApplicationSeleniumTest {

	public static void main(String[] args) {
		//if you didn't update the Path system variable to add the full directory path to the executable as above mentioned then doing this directly through code
//		System.setProperty("webdriver.gecko.driver", "path/to/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\dev\\testing\\selenium\\zip-file\\gecko-driver\\geckodriver-v0.21.0-win64\\geckodriver.exe");
//		System.setProperty("webdriver.gecko.driver", "C:/dev/testing/selenium/zip-file/gecko-driver/geckodriver-v0.21.0-win64/geckodriver.exe");

		//Now you can Initialize marionette driver to launch firefox
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		
		WebDriver driver = new FirefoxDriver();
		
		 //Launch the Online Store Website
		driver.get("http://localhost:8080/login/index.html");
		
       // Print a Log In message to the screen
       System.out.println("Successfully opened the website localhost");

		//Wait for 5 Sec
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
       // Close the driver
       driver.quit();
	}
	
}
