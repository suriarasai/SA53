package sg.edu.nus.welcome.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sg.edu.nus.welcome.model.LineItem;

public interface LineItemRepo extends JpaRepository<LineItem, Integer> {

}
