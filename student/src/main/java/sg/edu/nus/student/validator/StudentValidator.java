package sg.edu.nus.student.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import sg.edu.nus.student.model.Student;

public class StudentValidator implements Validator {
	
	/** This Validator validates *just* Person instances **/
	public boolean supports(Class clazz) {
		return Student.class.equals(clazz);
	}
	public void validate(Object obj, Errors e) {
		Student s = (Student) obj;
		if (s.getCap() > 5) {
			e.rejectValue("cap", "cap");
		}
	}


}
