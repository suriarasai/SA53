package sg.edu.nus.welcome.datatests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import sg.edu.nus.welcome.model.Product;
import sg.edu.nus.welcome.repo.ProductRepo;

@SpringBootTest
public class ProductTests {

	@Autowired
	ProductRepo prepo;

	@Test
	@Order(1)
	void createProducts() {
		prepo.deleteAll();
		ArrayList<Product> plist = new ArrayList<Product>();
		Product p1 = new Product("shoes", "sports shoes 38 size", 50.00);
		Product p2 = new Product("shoes", "sports shoes 40 size", 50.00);
		Product p3 = new Product("shoes", "sports shoes 42 size", 50.00);
		Product p4 = new Product("socks", "Woolen pair of socks S size", 50.00);
		Product p5 = new Product("socks", "Woolen pair of socks M size", 50.00);
		Product p6 = new Product("socks", "Woolen pair of socks L size", 50.00);
		Product p7 = new Product("jerkin", "sports wear S size", 50.00);
		Product p8 = new Product("jerkin", "sports shoes M size", 50.00);
		Product p9 = new Product("jerkin", "sports shoes L size", 50.00);
		Product p10 = new Product("jerkin", "sports shoes XL size", 50.00);
		plist.add(p1);plist.add(p2);plist.add(p3);plist.add(p4);plist.add(p5);
		plist.add(p10);plist.add(p9);plist.add(p8);plist.add(p7);plist.add(p6);
		prepo.saveAllAndFlush(plist);
		Integer currentSize = prepo.findAll().size(); 
		assertEquals(currentSize, 10);
		
	}

	@Test
	@Order(2)
	public void testFindAll() {
		
		
	}
	
	@Test
	@Order(3)
	public void testFindByName() {
		
	}
	

}
