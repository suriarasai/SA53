package sg.edu.nus.student.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.nus.student.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

	
	@Transactional
	@Modifying
	@Query("Update Account a SET a.balance = a.balance - :amount where a.accountNumber = :accountNumber")
	public Integer debit(@Param("accountNumber") Integer accountNumber , @Param("amount") Double amount);
	
	@Transactional
	@Modifying
	@Query("Update Account a SET a.balance = a.balance + :amount where a.accountNumber = :accountNumber")
	public Double credit(@Param("accountNumber") Integer accountNumber , @Param("amount") Double amount);
	

}
