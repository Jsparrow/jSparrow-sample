package sample.unused.methods;

public class UnusedMethodsSample {

	private void unusedPrivateMethod() {}

	private void run() {
		System.out.println("Running...");
	}

	public static void main() {
		UnusedMethodsSample instance = new UnusedMethodsSample();
		instance.run();
	}

}
