package ie.murph.sellyourownhome.selenium;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import ie.murph.sellyourownhome.selenium.login.LoginPageSeleniumTest;

@SpringBootApplication
public class SellYourOwnHomeApplicationSeleniumTest {

	public static void main(String[] args) {
		LoginPageSeleniumTest LoginPageSeleniumTest = new LoginPageSeleniumTest();
		LoginPageSeleniumTest.run();
	}
}
