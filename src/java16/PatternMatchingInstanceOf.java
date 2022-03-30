package java16;

public class PatternMatchingInstanceOf {

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
