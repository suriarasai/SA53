package sg.edu.nus.student.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
	
	private String name;
	private String password;
	public User(String username, String password) {
		super();
		this.name = username;
		this.password = password;
	}
	
}
