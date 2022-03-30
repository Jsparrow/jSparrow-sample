package sample.markers;

import org.apache.commons.lang3.StringUtils;

public class RemoveToStringOnString {
	public String testToStringOnStringLiteral() {
		String s = "anStringLiteral".toString();
		return "anStringLiteral".toString();
	}

	public String testToStringOnStringVariable() {
		String s = "theStringS";
		return s.toString();
	}

	public String testToStringOnStringFunctionThatReturnsString() {
		return StringUtils.abbreviate("makeMeShorter", 4);
	}

	public String testToStringOnParenthesizeString(String s) {
		return (s).toString();
	}

	public String testToStringOnParenthesizePlusString(String s) {
		return s + "abc";
	}
}
