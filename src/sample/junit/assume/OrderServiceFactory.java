package sample.junit.assume;

public class OrderServiceFactory {
	
	public static OrderService get() {
		return new OrderService();
	}

}
