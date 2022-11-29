package ch.sh.springmaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMasterApplication.class, args);
	}

	@GetMapping
	Customer getCustomer(){
		return new Customer(1L, "Chyngyz Sharshekeev");
	}

	class Customer{
		private final  Long id;
		private final  String name;

		Customer(Long id, String name) {
			this.id = id;
			this.name = name;
		}

		public Long getId() {
			return id;
		}

		public String getName() {
			return name;
		}
	}


}
