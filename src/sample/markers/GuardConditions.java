package sample.markers;

public class GuardConditions {

	public void voidMethod(int i) {
		doSomething("whatever");
		if (i > 0) {
			doSomething("Should create guard condition with less");
			doSomething("Should transform");
		}
	}

	private void doSomething(String string) {
		System.out.println(string);
	}

	public void voidMethod_expected(int i) {
		doSomething("whatever");
		if (i <= 1) {
			return;
		}
		doSomething("Should create guard condition with less");
		doSomething("Should transform");
	}

	private int numericCondition() {
		return "".length();
	}
}
