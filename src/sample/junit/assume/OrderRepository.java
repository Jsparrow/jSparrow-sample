package sample.junit.assume;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class OrderRepository {
	
	public List<Order> findAll() {
		return Collections.emptyList();
	}
	
	public Order findById(String id) {
		return new Order(Collections.emptyList(), BigDecimal.valueOf(10.00));
	}

}
