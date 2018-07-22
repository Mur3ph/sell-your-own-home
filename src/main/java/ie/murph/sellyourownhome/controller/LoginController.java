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
	private static final String urlLoginPage = "/login/index";
	private static final String urlExceptionError404 = "/exceptions/error-404";
	private static final String urlExceptionSuccess = "/exceptions/success";
	private static Person person;

	@Autowired
	private LoginService loginService;

	// http://localhost:8080/login/index
	@RequestMapping(value = urlLoginPage, method = RequestMethod.GET)
	public String routeToLoginPage(Model model) {
		LOGGER.info("++routeToLoginPage()");
		passPersonObjectToLoginPage(model);
		LOGGER.info("--routeToLoginPage()");
		return urlLoginPage;
	}

	public void passPersonObjectToLoginPage(Model model) {
		model.addAttribute("person", new Person());
	}

	// Where to go after the login success page
	@RequestMapping(value = urlLoginPage, method = RequestMethod.POST)
	public String login(@RequestParam(value = "username", required = false) String username,
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
			url = urlExceptionError404;
		} else {
			url = urlExceptionSuccess;
		}
		return url;
	}

	private boolean pesonIsNull() {
		return person == null;
	}

	@RequestMapping(value = urlExceptionSuccess, method = RequestMethod.GET)
	public String homePage(Model model) {
		LOGGER.info("+homePage()");
		model.addAttribute("person", new Person());
		return urlExceptionSuccess;
	}
	
	@RequestMapping(value = urlExceptionError404, method = RequestMethod.GET)
	public String errorPage() {
		LOGGER.info("+errorPage()");
		return urlExceptionError404;
	}

}
