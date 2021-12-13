package sg.edu.nus.student.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.student.model.Account;
import sg.edu.nus.student.repo.AccountRepository;

@Service
public class MoneyTransferImpl implements MoneyTransfer {
	
	@Autowired
	AccountRepository arepo;

	
	@Transactional
	@Override
	public boolean transfer(Account from, Account to, Double amount) {
		arepo.debit(from.getAccountNumber(), amount);
		arepo.credit(to.getAccountNumber(), amount);
		return true;
	}

}
