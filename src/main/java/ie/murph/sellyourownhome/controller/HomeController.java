package ie.murph.sellyourownhome.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@EnableAutoConfiguration
public class HomeController {
	
//	http://localhost:8080/home
	@RequestMapping("/home")
    String hello() {
        return "Home page *Sell Your Own Home*";
    }

}
