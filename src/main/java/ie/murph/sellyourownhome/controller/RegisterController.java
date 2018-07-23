package ie.murph.sellyourownhome.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterController.class);

	@RequestMapping(value = "/register/index", method = RequestMethod.GET)
	public String registerPage(Model model) {
		LOGGER.info("++registerPage()");
		return "/register/index";
	}

}
