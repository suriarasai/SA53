package sg.edu.nus.welcome;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sg.edu.nus.welcome.model.Customer;
import sg.edu.nus.welcome.model.Product;
import sg.edu.nus.welcome.repo.CustomerRepo;
import sg.edu.nus.welcome.repo.ProductRepo;

@SpringBootApplication
public class WelcomeApplication {

	@Autowired
	ProductRepo prepo;

	@Autowired
	CustomerRepo crepo;

	public static void main(String[] args) {
		SpringApplication.run(WelcomeApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Customer c = new Customer("Xin", "ISS");
			Customer c1 = new Customer("Theresa", "ISS");
			Product p = new Product("headset", "bluetooth enabled speaker and mic", 100.00);
			crepo.saveAndFlush(c);
			crepo.saveAndFlush(c1);
			prepo.saveAndFlush(p);
			ArrayList<Product> plist = (ArrayList) prepo.findAll();
			for (Product current : plist) {
				System.out.println(current.toString());
			}

			ArrayList<Customer> clist = (ArrayList) crepo.findAll();
			for (Customer current : clist) {
				System.out.println(current.toString());
			}

			ArrayList<Customer> c1list = (ArrayList) crepo.findCustomersByName("Xin");
			for (Customer current : c1list) {
				System.out.println(current.toString());
			}
		};
	}

}
