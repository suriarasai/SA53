package sg.edu.nus.welcome.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.nus.welcome.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	ArrayList<Customer> findCustomersByName(String name);
	
	

}
