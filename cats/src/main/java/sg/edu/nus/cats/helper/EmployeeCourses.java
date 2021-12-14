package sg.edu.nus.cats.helper;

import java.util.ArrayList;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import sg.edu.nus.cats.model.Course;
import sg.edu.nus.cats.model.Employee;
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class EmployeeCourses {

	private Employee employee = null;
    private ArrayList<Course> courses = null;
}
