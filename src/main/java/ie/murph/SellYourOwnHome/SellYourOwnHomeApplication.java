package ie.murph.SellYourOwnHome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class SellYourOwnHomeApplication {
	
	@RequestMapping("/")
    String hello() {
        return "How about you *Sell Your Own Home*";
    }

	public static void main(String[] args) {
		SpringApplication.run(SellYourOwnHomeApplication.class, args);
	}
	
//	http://localhost:8080/
}
