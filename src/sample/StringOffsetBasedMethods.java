package sample;

import org.apache.commons.lang3.StringUtils;

public class StringOffsetBasedMethods {
	private static final String VALUE = "I wish to wish the wish you wish to wish";
	
	public static void main(String []args) {
		StringOffsetBasedMethods o = new StringOffsetBasedMethods();
		o.compareIndexOf("wish", 7);
		o.compareStartsWith("wish", 10);
		o.compareLastIndexOf("t", 14);
	}
	
	private void compareIndexOf(String search, int offset) {
		int i = VALUE.substring(offset).indexOf(search);
		int j = VALUE.indexOf(search, offset) > 0 ? VALUE.indexOf("wish", offset) - offset : -1;
		int k = Math.max(-1, VALUE.indexOf(search, offset) - offset);
		System.out.println("IndexOf: i: " + i + ", j: " + j + ", k: " + k);
	}
	
	private void compareStartsWith(String search, int index) {
		boolean i = VALUE.substring(index).startsWith(search);
		boolean j = VALUE.startsWith(search, index);
		System.out.println("StartsWith: i: " + i + ", j: " + j);
	}
	
	private void compareLastIndexOf(String search, int offset) {
		int i = VALUE.substring(offset).lastIndexOf(search);
		int j = VALUE.lastIndexOf(search, offset);
		int k = Math.max(VALUE.lastIndexOf(search) - offset, -1);
		System.out.println("LastIndexOf: i: " + i + ", j: " + j + ", k: " + k);
	}
	
	private void usingStringUtils(String search, int offset) {
		int i = StringUtils.indexOf(VALUE, search, offset);
	}

}
