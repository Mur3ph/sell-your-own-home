package ie.murph.sellyourownhome;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellYourOwnHomeApplicationTests {

	@Test
	public void contextLoads() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		
		 //Launch the Online Store Website
		driver.get("http://localhost:8080/login");
		
        // Print a Log In message to the screen
        System.out.println("Successfully opened the website localhost");
 
		//Wait for 5 Sec
		Thread.sleep(5000);
		
        // Close the driver
        driver.quit();
	}

}
