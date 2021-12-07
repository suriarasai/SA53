package sg.edu.nus.welcome.service;

import java.util.HashSet;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import sg.edu.nus.welcome.model.Address;
import sg.edu.nus.welcome.model.Customer;
import sg.edu.nus.welcome.model.LineItem;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Override
	public int insertOrder(Customer c, Address sa, Address ba, HashSet<LineItem> li)  {
		
		// Logic - check c is valid
				//Throw Exception
		// check sa ba is valid 
		// li 
		// isert
		return 0;
	}
	
}
