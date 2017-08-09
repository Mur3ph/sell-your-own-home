package ie.murph.sellyourownhome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	// http://localhost:8080/home/index
	@RequestMapping(value = "/home")
	public String index(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "home/index";
	}

	// http://localhost:8080/greeting
	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	// http://localhost:8080/home/index
	@RequestMapping("home/index")
	public String fibonacci(Integer fib, Model model) {
		model.addAttribute("fib", MrFibonacci(7));
		return "home/index";
	}

	public int MrFibonacci(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return MrFibonacci(n - 1) + MrFibonacci(n - 2);
	}

	// http://localhost:8080/home/index/7 Return 13
	@RequestMapping("home/index/{fibPathVar}")
	public String fibonacciPathVar(@PathVariable("fibPathVar") Integer fibPathVar, Model model) {
		model.addAttribute("fibPathVar", MrFibonacci(fibPathVar));
		return "home/index";
	}

	// @RequestMapping(value="/index", method=RequestMethod.GET)
	// public String allowAccessToLoginPagePost()
	// {
	// return "Home page *Sell Your Own Home* Get method";
	// }

	// @RequestMapping(value="/index", method=RequestMethod.POST)
	// public String allowAccessToLoginPagePost()
	// {
	// return "Home page *Sell Your Own Home* Post method";
	// }

}
