package sample.junit.assume;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public class Order {

	public List<String> items;
	public BigDecimal totalPrice;

	public Order(List<String> items, BigDecimal totalPrice) {
		this.items = items;
		this.totalPrice = totalPrice;
	}

	public List<String> getItems() {
		return items;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void checkingMarkers() {

		Runnable r = () -> {
			System.out.print("");
		};
		
		r.run();

		r = new Runnable() {
			@Override
			public void run() {
				System.out.print("");
			}
		};

		System.out.print("");
		r.run();
		r = new Runnable() {
			@Override
			public void run() {
				System.out.print("");
			}
		};
		r.run();
		
		r =  new Runnable() {
			@Override
			public void run() {
				System.out.print("");
			}
		};

		r.run();
		r =  new Runnable() {
			@Override
			public void run() {
				System.out.print("");
			}
		};
		r.run();
	}

	public void usingComparators() {
		Comparator<Integer> comparator = (lhs, rhs) -> lhs.compareTo(rhs);
		comparator.compare(5, 10);
		
		Comparator<Integer> comparator2 = (lhs, rhs) -> rhs.compareTo(lhs);
		comparator2.compare(5, 10);
	}
}
