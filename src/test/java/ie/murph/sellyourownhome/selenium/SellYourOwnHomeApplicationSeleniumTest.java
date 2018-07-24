package ie.murph.sellyourownhome.selenium;

import org.springframework.boot.test.context.SpringBootTest;

import ie.murph.sellyourownhome.selenium.login.LoginPageSeleniumTest;

@SpringBootTest
public class SellYourOwnHomeApplicationSeleniumTest {

	public static void main(String[] args) {
		LoginPageSeleniumTest LoginPageSeleniumTest = new LoginPageSeleniumTest();
		LoginPageSeleniumTest.run();
	}
}
