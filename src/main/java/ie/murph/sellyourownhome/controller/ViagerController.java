package ie.murph.sellyourownhome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViagerController {

	// http://localhost:8080/viager/index
	@RequestMapping("viager/index")
	public String viager() {
		return "viager/index";
	}
}
