package sg.edu.nus.welcome.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sg.edu.nus.welcome.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}