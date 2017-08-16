package ie.murph.sellyourownhome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

	// http://localhost:8080/test/index
	@RequestMapping(value = "/test")
	public String index(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "test/index";
	}

	// http://localhost:8080/greeting
	@RequestMapping("test/greeting")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "test/greeting";
	}

	// http://localhost:8080/home/index
	@RequestMapping("test/index")
	public String fibonacci(Integer fib, Model model) {
		model.addAttribute("fib", MrFibonacci(7));
		return "test/index";
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
	@RequestMapping("test/index/{fibPathVar}")
	public String fibonacciPathVar(@PathVariable("fibPathVar") Integer fibPathVar, Model model) {
		model.addAttribute("fibPathVar", MrFibonacci(fibPathVar));
		return "test/index";
	}

	// @RequestMapping(value="test/index", method=RequestMethod.GET)
	// public String allowAccessToLoginPagePost()
	// {
	// return "Home page *Sell Your Own Home* Get method";
	// }

	// @RequestMapping(value="test/index", method=RequestMethod.POST)
	// public String allowAccessToLoginPagePost()
	// {
	// return "Home page *Sell Your Own Home* Post method";
	// }

}
