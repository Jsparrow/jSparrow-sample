package java16;

public class PatternMatchingInstanceOfHidingField {
	String value = null;
	void test() {
		Object o = "";
		if(o instanceof String) {
			String value = (String)o;		
			showValue(value);
		}
	}
	void showValue(String value) {
		
	}
}