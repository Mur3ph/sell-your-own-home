package ie.murph.sellyourownhome.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ie.murph.sellyourownhome.domain.Person;
import ie.murph.sellyourownhome.service.RegisterService;

@Controller
public class RegisterController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterController.class);
	private final String urlRegisterPage = "/register/index";
	@Autowired
	private RegisterService registerService;

	@RequestMapping(value = urlRegisterPage, method = RequestMethod.GET)
	public String getRegisterPage(Model model) {
		LOGGER.info("++getRegisterPage()");
		passPersonObjectToLoginPage(model);
		return "/register/index";
	}

	private void passPersonObjectToLoginPage(Model model) {
		model.addAttribute("person", new Person());
	}

	// Where to go after the login success page
	@RequestMapping(value = urlRegisterPage, method = RequestMethod.POST)
	public String registerPersonalDetails(
			Person person, 
			Model model) {
		LOGGER.info("++registerPersonalDetails()");
		person = registerService.register(person);
		registerPersonDetails(model, person);
		return "/login/index";
	}

	private void registerPersonDetails(Model model, Person person) {
		model.addAttribute("person", person);
	}
}
