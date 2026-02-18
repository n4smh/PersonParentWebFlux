package in.n4smh.microservices.person.parent_webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "in.n4smh.microservices.person")
public class PersonParentWebFluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonParentWebFluxApplication.class, args);
	}

}
