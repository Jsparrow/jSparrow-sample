package sample.switchcase;

public class SwitchAssigningValues {

	void assignStringValue_shouldTransform(int digit) {
		String value;
		switch (digit) {
		case 0:
			value = "zero";
			break;
		case 1:
			value = "one";
			break;
		case 2:
			value = "two";
			break;
		case 3:
			value = "three";
			break;
		default:
			value = "other";
		}
	}

	void reassignMethodParameter(int j) {
		for (int i = 0; i < 10; i++) {
			switch (i) {
			case 1:
				j = 0;
				break;
			case 2:
				j = 5;
				break;
			default:
				j = i - 1;
			}
		}
	}

	void reassignField_shouldTransform() {
		int digit = 0;
		switch (digit) {
		case 1:
			field = "one";
			break;
		case 2:
			field = "two";
			break;
		default:
			field = "other";
		}
	}

	String field = "";

	void reassignWithFieldAccess_shouldTransform() {
		int digit = 0;
		switch (digit) {
		case 1:
			this.field = "one";
			break;
		case 2:
			this.field = "two";
			break;
		default:
			this.field = "other";
		}
	}

	void assignDifferentValues_shouldTransform() {
		int digit = 0;
		String value = "test";
		String value2 = "value2";
		switch (digit) {
		case 1:
			value = "one";
			break;
		case 2:
			value2 = "two";
			break;
		default:
			value = "other";
		}
	}

	void reassignStringValue_shouldTransform() {
		int digit = 0;
		String value = "test";
		System.out.println(value);
		switch (digit) {
		case 1:
			value = "one";
			break;
		case 2:
			value = "two";
			break;
		case 3:
			value = "three";
			break;
		default:
			value = "other";
		}
	}

	void reassigningParentBlockVar_shouldTransform() {
		int digit = 0;
		String value = "test";
		if (digit > 0) {
			System.out.println(value);
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
	}

	void methodInvocationInitializer_shouldTransform() {
		int digit = 0;
		String value = "test".substring(2);
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

	void noInitializer_shouldTransform() {
		int digit = 0;
		String value;
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

	void multipleFragments_shouldTransform() {
		int digit = 0;
		String value = "test", value2 = "test2";
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

	void missingDefaultClause_shouldTransform(int digit) {
		String value;
		switch (digit) {
		case 0:
			value = "zero";
			break;
		case 1:
			value = "one";
			break;
		case 2:
			value = "two";
			break;
		}
	}

	void reassigned_shouldTransform(int digit) {
		String value = "";
		switch (digit) {
		case 0:
			value = "zero";
			break;
		case 1:
			value = "one";
			break;
		case 2:
			value = "two";
			break;
		default:
			value = "other";
			break;
		}
	}

	void reassignedMissingDefault_shouldTransform(int digit) {
		String value = "";
		switch (digit) {
		case 0:
			value = "zero";
			break;
		case 1:
			value = "one";
			break;
		case 2:
			value = "two";
			break;
		}
	}

	void switchCaseMultipleStatements_shouldTransform(int digit) {
		String value;
		switch (digit) {
		case 0:
			System.out.println();
			value = "zero";
			break;
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

	void switchCaseBlock_shouldTransform(int digit) {
		String value;
		switch (digit) {
		case 0: {
			System.out.println();
			value = "zero";
			break;
		}
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

	void combineCaseClauses_shouldTransform(int digit) {
		String value;
		switch (digit) {
		case 0:
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

	void multipleBreakStatements_shouldTransform(int digit2) {
		int digit = 0;
		String value;
		switch (digit) {
		case 1:
			value = "one";
			if (value.isEmpty()) {
				value = "";
				break;
			}
			value = "one";
			break;
		case 2:
			value = "two";
			break;
		default:
			value = "none";
			break;
		}
	}

	void plusEqualsOperand_shouldTransform() {
		String value = "";
		int digit = 0;
		switch (value) {
		case "1":
			digit += 1;
			break;
		case "2":
			digit += 2;
			break;
		default:
			digit += 0;
			break;
		}
	}
}
