package sg.edu.nus.welcome.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.nus.welcome.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {
	
	ArrayList<Product> readProductsByName(String name);

}
