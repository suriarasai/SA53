package sg.edu.nus.welcome.addresstests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import sg.edu.nus.welcome.WelcomeApplication;
import sg.edu.nus.welcome.model.Address;
import sg.edu.nus.welcome.model.Customer;
import sg.edu.nus.welcome.repo.AddressRepo;
import sg.edu.nus.welcome.repo.CustomerRepo;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = WelcomeApplication.class)
@TestMethodOrder(OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AddressUnitTests {
	
	@Autowired
	AddressRepo arepo;
	
	@Autowired
	CustomerRepo crepo;
	
	@Test
	@Order(1)
	public void testCustomerUsingAddresses() {
		arepo.deleteAll();
		crepo.deleteAll();
		Address address1 = new Address("25 Heng Mui Keng Terrace", "Singapore", "Singapore");
		Address address2 = new Address("29 Heng Mui Keng Terrace", "Singapore", "Singapore");
		Address address3 = new Address("15 Heng Mui Keng Terrace", "Singapore", "Singapore");
		HashSet<Address> alist = new HashSet<Address>();
		alist.add(address1); alist.add(address2); alist.add(address3);
		arepo.saveAllAndFlush(alist);
		Customer customer = new Customer("Admin Head", alist);
		crepo.saveAndFlush(customer);
			
	}
	

}
