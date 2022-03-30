package sample.junit.assume;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assume.assumeTrue;

import org.junit.Test;

public class OrderTest {

	@Test
	public void testService() {
		assumeTrue(orderService.isAvailableInStock("1", 5));
		Order order = orderService.book("1", 5, "user-id");
		assertNotNull(order);
	}

	OrderService orderService = new OrderService();
}
