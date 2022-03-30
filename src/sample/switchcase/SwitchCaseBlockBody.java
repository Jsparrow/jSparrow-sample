package sample.switchcase;

public class SwitchCaseBlockBody {

	void switchCaseBlock_shouldTransform() {
		int digit = getClass().getName().length();
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

		default:
			value = "other";
		}
	}

}
