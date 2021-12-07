package sg.edu.nus.welcome.repo;

import java.util.ArrayList;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.nus.welcome.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	ArrayList<Customer> findCustomersByName(String name);
	
	@Query("Select c from Customer c where c.name = :name")
	Customer readCustomerByNameAndAddress(@Param("name") String n);
	
	@Query("Select c from Customer c where c.name like :name")
	ArrayList<Customer> readCustomerSortedByName(@Param("name") String n, Sort sort);
	
	
	//@Query("Select c from Customer c where c.address.street like :address")
	//ArrayList<Customer> readAndSortByAddress(@Param("address") String a, Sort sort);
	
	
	ArrayList<Customer> readByAddress_StreetLike(String street);
}
