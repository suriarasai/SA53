package sg.edu.nus.student.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.student.model.User;

@Controller
@RequestMapping("/common")
public class CommonController {

	@RequestMapping("/login")
	public String getLoginPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}
	
	@RequestMapping("/authenticate")
	public String authenticate(@ModelAttribute ("user") User user, HttpSession session) {
		
		if (user.getName().equalsIgnoreCase("dilbert"))
		{ 
			session.setAttribute("usession", user);
			return("welcome");
		}
		else
			return ("error");
	}

}
