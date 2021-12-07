package sg.edu.nus.welcome.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sg.edu.nus.welcome.model.ParkingSpace;

public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, Integer>{

}
