package java16;

public class PatternMatchingNotInstanceOfReturn {

	boolean testNotInstanceOfThenReturn(Object o) {
		if (!(o instanceof String))
			return false;
		String value = (String)o;
		return "".equals(value);
	}

	boolean testNotInstanceOfThenBlockEndingWithReturn(Object o) {
		if (!(o instanceof String)) {
			return false;
		}
		String value = (String)o;
		return "".equals(value);
	}
	
	boolean testNotInstanceOfThenBlockEndingWithReturn2(Object o) {
		if (!(o instanceof String)) {
			String value = "";
			return true;
		}
		String value = (String)o;
		return "".equals(value);
	}
	
	boolean withReturn(Object o) {
		if (!(o instanceof String)) {
			dontShowValue();
			return false;
		}
		String value = (String)o;
		showValue(value);
		return "Olympics 2020".equals(value);
	}
	
	void dontShowValue() {
		
	}
	
	void showValue(String value) {
		
	}
}
