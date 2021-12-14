package sg.edu.nus.cats.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.nus.cats.model.CourseEvent;

public interface CourseEventRepository extends JpaRepository<CourseEvent, Integer>{
	
	

}
