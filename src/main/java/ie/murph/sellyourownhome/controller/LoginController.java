package ie.murph.sellyourownhome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
		
	// http://localhost:8080/login/index
	@RequestMapping(value = "login/index")
	public String index() {
		return "login/index";
	}

}
