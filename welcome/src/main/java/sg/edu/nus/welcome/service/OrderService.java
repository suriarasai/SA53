package sg.edu.nus.welcome.service;

import java.util.HashSet;

import sg.edu.nus.welcome.model.Address;
import sg.edu.nus.welcome.model.Customer;
import sg.edu.nus.welcome.model.LineItem;

public interface OrderService {

	int insertOrder(Customer c, Address sa, Address ba, HashSet<LineItem> li);

}