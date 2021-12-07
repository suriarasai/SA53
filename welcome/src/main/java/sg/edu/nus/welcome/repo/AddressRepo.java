package sg.edu.nus.welcome.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sg.edu.nus.welcome.model.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}
