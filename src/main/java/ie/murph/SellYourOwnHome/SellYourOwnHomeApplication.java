package ie.murph.sellyourownhome;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories 
public class SellYourOwnHomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellYourOwnHomeApplication.class, args);
		
//		ApplicationContext ctx = SpringApplication.run(SellYourOwnHomeApplication.class, args);

//        System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//        String[] beanNames = ctx.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }
	}
	
}
