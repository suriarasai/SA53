package sg.edu.nus.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.nus.student.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
