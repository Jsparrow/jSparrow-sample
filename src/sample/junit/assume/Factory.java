package sample.junit.assume;

public class Factory {

	public static OrderRepository getOrderRepo() {
		return new OrderRepository();
	}
}
