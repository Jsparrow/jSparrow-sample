package sample.switchcase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class SwitchCaseNegativeTests {

	void undefinedVariable() {
		int value = "".length();
		switch (value) {
		case 1:
			String t = "1";
			break;
		case 2:
			t = "2";
			break;
		default:
			System.out.println("none");
		}
	}

	void alreadyTransformed() {
		String t = "";
		int value = "".length();
		switch (value) {
		case 0 -> t = "";
		case 1 -> t = "not-empty";
		case 2 -> t = "2";
		default -> t = "not-empty";
		}
		System.out.println(t);
	}

	void labeledSwitchCase() {
		int value = "".length();
		switch (value) {
		case 1: {
			label_1: switch (value) {
			case 0:
				System.out.println();
				break label_1;
			}
		}
		}
	}

	void missingBreakStatement2_shouldTransform() {
		int digit = 10;
		String value;
		switch (digit) {
		case 0:
			value = "zero";
			break;
		case 1:
			value = "one";
		default:
			value = "other";
		}
	}

	void missingBreakStatement_shouldTransform() {
		int digit = 10;
		String value;
		switch (digit) {
		case 0:
			value = "zero";
		case 1:
			value = "one";
			break;
		default:
			value = "other";
		}
	}

	void multipleBreakStatements() {
		int digit = 0;
		String value;
		switch (digit) {
		case 1 -> {
			value = "one";
			if (value.isEmpty()) {
				value = "";
				break;
			}
			value = "one";
		}
		case 2 -> value = "two";
		}
	}

	@Test
	public void testWithConditionalContinueLabeledLoop() {
		String value = "";
		loop: for (int indexInner = 0; indexInner < 5; indexInner++) {
			int digit = indexInner % 2;
			switch (digit) {
			case 1:
				if (indexInner > 2) {
					// causes compilation error in transformed code
					continue loop;
				}
				value = "one";
				break;
			default:
				value = "other";
			}

		}
	}

	void combineSwitchCaseWithDefault() {
		int digit = 0;
		switch (digit) {
		case 1:
			System.out.println("one");
			break;
		case 2:
			System.out.println("two");
		default:
			System.out.println("none");
		}
	}
}
