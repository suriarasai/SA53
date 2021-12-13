package sg.edu.nus.student.service;

import sg.edu.nus.student.model.Account;

public interface MoneyTransfer {

	  public boolean transfer(Account from, Account to, Double amount);
	  
}
