package sg.edu.nus.welcome.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@GetMapping("/h1")
	public String sayHello(Model model) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
	      Calendar cal = Calendar.getInstance();
	      model.addAttribute("today", dateFormat.format(cal.getTime()));
	      return "greetings"; 
	}
}
