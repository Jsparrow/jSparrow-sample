package sample.switchcase;

public class SwitchExamples {

	private int savingComments() {
		int digit = 0;
		String value = "test";
		System.out.println("Initial value: " + value);
		// leading comment
		switch (digit) {
		case 1:
			value = "one";
			break;
		case 2: {
			// 2
			System.out.println("Two");
			value = "two";
			break;
		}
		default:
			value = "none";
		}
		return 1;
	}
	
	private int javaDocsExample() {
		int digit = 0;
		String value = "test";
		switch (digit) {
		case 1:
			value = "one";
			break;
		case 2:
			value = "two";
			break;
		default:
			value = "none";
		}
		return 1;
	}

	private int returningStatements() {
		int digit = 0;
		String value = "test";
		switch (digit) {
		case 1:
			value = "one";
			break;
		case 2:
			value = "two";
			break;
		default:
			return 0;
		}
		return 1;
	}

	private static final int TEN = 10;

	private static final String CLAZZ = SwitchExamples.class.getName();

	enum Days {
		MONDAY, TUESDAY
	}

	void throwingException() {
		int digit = 0;
		String value = "test";
		switch (digit) {
		case 1:
			value = "one";
			break;
		case 2:
			value = "two";
			break;
		default:
			throw new RuntimeException();
		}
	}

	void missingParentBlock_shouldTransform() {
		int digit = 0;
		String value = "test";
		if (true)
			switch (digit) {
			case 1:
				value = "one";
				break;
			case 2:
				value = "two";
				break;
			default:
				value = "other";
			}
	}

	String simpleValue = "test";

	void multipleStatementsYieldValue() {
		int digit = 0;
		switch (digit) {
		case 1:
			System.out.println("Value: 1");
			simpleValue = "one";
			break;
		case 2:
			simpleValue = "two";
			break;
		default:
			simpleValue = "other";
		}
		System.out.println(simpleValue);
	}

	void multipleStatementsInSwitchCase() {
		int digit = 0;
		String value = "test";
		switch (digit) {
		case 1:
			value = "one";
			System.out.println("Value: ");
			System.out.println(value);
			break;
		case 2:
			value = "two";
			break;
		default:
			value = "other";
		}
	}

	void emptySwitchCases() {
		int digit = 0;
		String value = "test";
		switch (digit) {
		case 1:
			break;
		case 2:
			break;
		default:
		}
	}

	void loopInSwitchCase() {
		int digit = 0;
		String value = "test";
		switch (digit) {
		case 1:
			while (true) {
				value = "one";
				break;
			}
			break;
		case 2:
			value = "two";
			break;
		default:
			value = "other";
		}
	}

	void multipleStatementsInSwitchCase_transformed() {
		int digit = 0;
		String value = "test";
		switch (digit) {
		case 1 -> {
			value = "one";
			System.out.println("Value: ");
			System.out.println(value);
			break;
		}
		case 2 -> value = "two";
		default -> value = "other";
		}
	}

	public void usingSwitchCaseExamples2(String value) {
		boolean truth;
		switch (value) {
		case "True":
		case "T":
		case "t":
			System.out.println("true");
			truth = true;
			if (value.isEmpty()) {
				break;
			} else if ("t".equals(value)) {
				return;
			}
			break;
		case "f":
			truth = false;
			System.out.println("False");
			break;
		default:
			truth = false;
			System.out.println("None");
			break;
		}
		System.out.println("Truth: " + truth);
	}

	public void usingSwitchCaseExamples() {
		String value = System.in.toString();
		switch (value) {
		case "t":
			System.out.println("true");
			break;
		case "f":
			System.out.println("False");
			break;
		default:
			System.out.println("None");
			break;
		}
	}

	public void usingSwitchCaseExamples_transformed(String value) {
		switch (value) {
		case "t" -> {
			System.out.println("true");
		}
		case "V" -> {
			SwitchExamples se = new SwitchExamples();
		}
		case "f" -> System.out.println("False");
		default -> System.out.println("None");
		}

	}

	public void usingSwitchCaseExamples2_transformed(String value) {
		boolean truth = switch (value) {
		case "t" -> {
			System.out.println("True");
			yield true;
		}
		case "f" -> {
			System.out.println("False");
			yield false;
		}
		default -> {
			System.out.println("None");
			yield false;
		}
		};
		System.out.println("Truth: " + truth);
	}

	public void usingSwitchCaseExamples2_1_transformed(String value) {
		String t = "";
		boolean truth = switch (value) {
		case "t" -> {
			t = "True";
			System.out.println("True");
			yield true;
		}
		case "f" -> {
			t = "False";
			System.out.println("False");
			yield false;
		}
		default -> {
			System.out.println("None");
			t = "None";
			yield false;
		}
		};
		System.out.println("Truth: " + truth);
	}

	public boolean usingSwitchCaseExamples3(String value) {
		switch (value) {
		case "t":
			return true;
		case "f":
			return false;
		default:
			return false;
		}
	}

	public boolean usingSwitchCaseExamples3_transformed(String value) {
		return switch (value) {
		case "t" -> true;
		case "f" -> false;
		default -> false;
		};
	}

}
