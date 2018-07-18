package ie.murph.sellyourownhome.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ie.murph.sellyourownhome.domain.Person;
import ie.murph.sellyourownhome.service.LoginService;

@Controller
public class LoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	private static final String urlLoginPage = "login/index";
	private static final String urlPersonHome = "house/index";
	private static final String urlUnsuccessfulLogin = "exceptions/login-unsuccessful";
	private static Person person;
	
	@Autowired
	private LoginService loginService;

	// http://localhost:8080/login/index
	@RequestMapping(value = urlLoginPage)
	public String routeToLoginPage(Model model) {
		LOGGER.info("++routeToLoginPage()");
		model.addAttribute("person", new Person()); 
		return urlLoginPage;
	}

	public void passPersonObjectToLoginPage(Model model) {
		model.addAttribute("person", new Person());
	}

	// Where to go after the login success page
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String submitLoginUsernameAndPassword(@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password", required = false) String password, Model model) {
		LOGGER.info("+submitLoginUsernameAndPassword()");
		person = loginService.doesPersonExist(username, password);
		saveUsersPersonalDetailsForHomePage(model, person);
		return url();
	}

	private void saveUsersPersonalDetailsForHomePage(Model model, Person person) {
		model.addAttribute("person", person);
	}

	private String url() {
		String url = "";
		if (pesonIsNull()) {
			url = urlUnsuccessfulLogin;
		} else {
			url = urlPersonHome;
		}
		return url;
	}
	
	private boolean pesonIsNull()
    {
    	return person == null;
}

}
