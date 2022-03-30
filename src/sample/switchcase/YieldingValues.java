package sample.switchcase;

public class YieldingValues {

	public void switchExpressionAssigningAValue_original(String someValue) {
		String t = someValue;
		do {
			if(t.length() > 0) {
				t = someValue.substring(0, someValue.length()-1);
			} else {
				break;
			}
		} while(t.length() > 5);
		
		String value = "";
		switch (someValue) {
		case "tr":
		case "t":
			System.out.println();
			value = "true";
			break;
		case "f":
		case "fl":
			value = "false";
			break;
		case "F":
		case "Fl":
		case "False":
			value = "False";
			break;
		case "True":
		case "Tr":
		case "T":
			value = "True";
			break;
		default:
			value = "None";

		}
		System.out.println("Value: " + value);
	}

	public void switchExpressionAssigningAValue_expected(String someValue) {
		String value = switch (someValue) {
		case "tr", "t" -> {
			System.out.println();
			yield "true";
		}
		case "f", "fl" -> "false";
		case "F", "Fl", "False" -> "False";
		case "True", "Tr", "T" -> "True";
		default -> "None";
		};
		System.out.println("Value: " + value);
	}

	public String switchExpressionReturningAValue_original(String someValue) {
		System.out.println();
		switch (someValue) {
		case "tr":
		case "t":
			System.out.println();
			return "true";
		case "f":
		case "fl":
			return "false";
		case "F":
		case "Fl":
		case "False":
			return "False";
		case "True":
		case "Tr":
		case "T":
			return "True";
		default:
			return "None";
		}
	}

	public String switchExpressionReturningAValue_expected(String someValue) {
		System.out.println();

		return switch (someValue) {
		case "tr", "t" -> {
			System.out.println();
			yield "true";
		}
		case "f", "fl" -> "false";
		case "F", "Fl", "False" -> "False";
		case "True", "Tr", "T" -> "True";
		default -> "None";
		};
	}

}
