package sg.edu.nus.mvcbe.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	StudentRepository srepo;
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		return srepo.findAll();
	}
	
	@PostMapping("/students")
	public Student createStudent(@RequestBody Student  student) {
		Student result = srepo.save(student);
		return result; 
	}

}
