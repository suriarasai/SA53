package sg.edu.nus.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sg.edu.nus.student.model.Account;
import sg.edu.nus.student.service.MoneyTransfer;

@SpringBootApplication
public class StudentApplication {
	
	//@Autowired
	//MoneyTransfer transfer;
	
	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}
	
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
	     // Account a = new Account(1, 1000.0, "John");
	    //  Account b = new Account(2, 500.0, "Jane");
	     // transfer.transfer(a, b, 50.0);
		};
	}
	

}
