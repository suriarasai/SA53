package sg.edu.nus.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import sg.edu.nus.student.service.MoneyTransfer;

@Controller
public class TransferController {
	
	@Autowired
	MoneyTransfer mtransfer;
	

	@GetMapping
	public String loadTrasferForm(Model model) {
		// create a empty model 
		
		return "transferform";
	}
	
	@PostMapping("/transfer")
	public String transferMoney(Model model) {
		// read the data and call the service
		
		
		return("success");
		
	}
}
