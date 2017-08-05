package ie.murph.sellyourownhome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	// http://localhost:8080/home/index
	@RequestMapping(value = "/home/index")
	public String index(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "home/index";
	}

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
	
//	@RequestMapping(value="/index", method=RequestMethod.GET)
//  public String allowAccessToLoginPagePost() 
//  {
//      return "Home page *Sell Your Own Home* Get method";
//  }
	
//	@RequestMapping(value="/index", method=RequestMethod.POST)
//  public String allowAccessToLoginPagePost() 
//  {
//      return "Home page *Sell Your Own Home* Post method";
//  }

}