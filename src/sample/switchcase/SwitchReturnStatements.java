package sample.switchcase;

public class SwitchReturnStatements {

	String assignStringValue_shouldTransform(int digit) {
		String value;
		switch (digit) {
		case 1:
			return "one";
		case 2:
			return "two";
		case 3:
			return "three";
		default:
			return "other";
		}
	}

	String multipleReturnStatements(int digit) {
		int i2 = 10;
		String value;
		switch (digit) {
		case 1:
			if (digit > i2) {
				return "10";
			}
			return "one";
		case 2:
			return "two";
		default:
			return "other";
		}
	}

	String multipleReturnStatements2(int digit) {
		int i2 = 10;
		String value;
		switch (digit) {
		case 1 -> {
			if (digit > i2) {
				return "10";
			}
			return "one";
		}
		case 2 -> {
			return "two";
		}
		default -> {
			return "other";
		}
		}
	}

	String usingThrowStatement(int digit) {
		switch (digit) {
		case 1:
			return "one";
		case 2:
			return "two";
		case 3:
			return "three";
		default:
			throw new RuntimeException("none");
		}
	}
}
