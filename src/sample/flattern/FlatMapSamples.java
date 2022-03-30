package sample.flattern;

import java.util.Collections;
import java.util.List;

public class FlatMapSamples {

	public void applyDiscount(List<User> users, Double percentage) {
		users.stream()
			.map(user -> findOrders(user))
			.forEach(orders -> 
				orders.forEach(order -> order.setPercentageDiscount(percentage)));

		users.stream().flatMap(user -> findOrders(user).stream()).forEach(order -> {
			order.setPercentageDiscount(percentage);
		});
	}
	
	
	public void mostSold(List<Order>orders) {
		orders.stream().map(Order::getOrderItems).forEach(items -> {
			items.forEach(item -> {
				Product product = item.getProduct();
				int quantity = item.getQuantity();
				add(product, quantity);
			});
		});
	}
	
	public void nestedCollection() {
		List<List<User>> groups = findGroups();
		groups.forEach(group -> {
			group.forEach(user -> {
				Product present = createPresent(user, findPreferences(user));
				send(user, present);
			});
		});
	}
	
	
	public void nestedCollection2() {
		List<List<User>> groups = findGroups();
		groups.forEach(group -> {
			group.forEach(user -> {
				sendAward(user);
			});
		});
	}
	
	
	
	private void add(Product product, int quantity) {
		
	}
	
	private void sendAward(User user) {
		
	}
	
	private UserPreferences findPreferences(User user) {
		return new UserPreferences();
	}

	private List<Order> findOrders(User user) {
		return Collections.emptyList();
	}
	
	private List<List<User>> findGroups() {
		return Collections.emptyList();
	}
	
	private void send(User user, Product product) {
		
	}
	
	private Product createPresent(User user, UserPreferences preference) {
		return null;
	}
}
