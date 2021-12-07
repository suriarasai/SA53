package sg.edu.nus.welcome.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.nus.welcome.model.Employee;



public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
