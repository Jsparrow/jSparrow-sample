package java16;

public class PatternMatchingNotInstanceOfElse {

	void testNotInstanceOfElse() {
		Object o = "";
		if (!(o instanceof String)) {

		} else {
			String value = (String) o;
			showValue(value);
		}
	}
	
	void testNotInstanceOfElse2() {
		Object o = "";
		if (!(o instanceof String)) {
			String value = "";
		} else {
			String value = (String) o;
			showValue(value);
		}
	}

	void showValue(String value) {

	}
}
