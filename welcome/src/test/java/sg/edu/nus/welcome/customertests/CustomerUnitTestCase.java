package sg.edu.nus.welcome.customertests;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import sg.edu.nus.welcome.WelcomeApplication;
import sg.edu.nus.welcome.model.Customer;
import sg.edu.nus.welcome.model.Product;
import sg.edu.nus.welcome.repo.CustomerRepo;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = WelcomeApplication.class)
@TestMethodOrder(OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerUnitTestCase {
	
	@Autowired
	CustomerRepo crepo;
	
	@Test
	@Order(1)
	public void testSomething() {
		crepo.deleteAll();
		Customer c = new Customer("Xin", "ISS");
		Customer c1 = new Customer("Theresa", "ISS");
		Customer c2 = new Customer("Melinda", "GM");
		Customer c3 = new Customer("Bhuvesh", "👍");   
		ArrayList<Customer> clist = new ArrayList<Customer>();
		clist.add(c);clist.add(c1);clist.add(c2);clist.add(c3);
		crepo.saveAllAndFlush(clist);
		ArrayList<Customer> rlist = (ArrayList) crepo.findAll();
		for (Customer current : rlist) {
			System.out.println(current.toString());
		}
		assertEquals(rlist.size(), 4);
		
	}
	
	@Test
	@Order(2)
	public void testReadByCusomerNameAndAddress() {
		crepo.deleteAll();
		Customer c = new Customer("Xin", "ISS");
		Customer c1 = new Customer("Theresa", "ISS");
		Customer c2 = new Customer("Melinda", "GM");
		Customer c3 = new Customer("Bhuvesh", "👍");   
		ArrayList<Customer> clist = new ArrayList<Customer>();
		clist.add(c);clist.add(c1);clist.add(c2);clist.add(c3);
		crepo.saveAllAndFlush(clist);
		Customer result = crepo.readCustomerByNameAndAddress("Bhuvesh", "👍");
		assertEquals(c3, result, "Test Case Failure");
		
	}
	
	@Test
	@Order(3)
	public void testReadAndSortByAddress() {
		crepo.deleteAll();
		Customer c = new Customer("Xin", "Germany");
		Customer c1 = new Customer("Theresa", "Island");
		Customer c2 = new Customer("Melinda", "Singapore Island");
		Customer c3 = new Customer("Bhuvesh", "Netherland");   
		ArrayList<Customer> clist = new ArrayList<Customer>();
		clist.add(c);clist.add(c1);clist.add(c2);clist.add(c3);
		crepo.saveAllAndFlush(clist);
		//
		//ArrayList<Customer> result = crepo.readAndSortByAddress("Island", new Sort("name"));
		
		//assertEquals(c3, result, "Test Case Failure");
		
	}

}
