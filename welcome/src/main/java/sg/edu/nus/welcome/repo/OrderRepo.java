package sg.edu.nus.welcome.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sg.edu.nus.welcome.model.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}
