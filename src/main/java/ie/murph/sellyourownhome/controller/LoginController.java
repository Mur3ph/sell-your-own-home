package ie.murph.sellyourownhome.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	private static final String urlLoginPage = "login/index";
		
	// http://localhost:8080/login/index
	@RequestMapping(value = urlLoginPage)
	public String routeToLoginPage() {
		LOGGER.info("++routeToLoginPage()");
		return urlLoginPage;
	}

}
