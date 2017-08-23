package ie.murph.sellyourownhome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HouseController {
	
	// http://localhost:8080/house/index
	@RequestMapping("house/index")
	public String index() {
		return "house/index";
	}
	
	@RequestMapping("house/property")
	public String property() {
		return "house/property";
	}

}
