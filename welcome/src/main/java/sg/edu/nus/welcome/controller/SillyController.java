package sg.edu.nus.welcome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sg.edu.nus.welcome.model.Address;

@Controller //Thymeleaf
// or RestController ReactJS
@RequestMapping("/first")
//GET POST DELETE 
public class SillyController {

	@PostMapping("/second")
	//accompinied by a <form></form>
	public String method1() {
		return "index";
	}

	@GetMapping("/second")
	public String method3() {
		return "index";
	}

	@GetMapping("/third")
	public String method2(Model model) {
		String message = "Some silly funny message";
		model.addAttribute("s", message);
		return "index";
	}
	
	@RequestMapping(value = "/fourth", method = RequestMethod.GET)
	// or @GetMapping
	public String method4() {
		return "index";
	}
	
	@GetMapping("/fifth")
	public String method5(@ModelAttribute("ads") Address a) {
		a.setStreet("street");
		a.setCity("SG");
		a.setCountry("SG");	
		return "atest";
	}
	
	

}
