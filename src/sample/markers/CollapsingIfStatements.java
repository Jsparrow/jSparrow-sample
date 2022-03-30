package sample.markers;

public class CollapsingIfStatements {

	public void foo(boolean a, boolean b) {
		if (a) {
			if (b) {
				System.out.println("Ok");
			}
		}
	}

	public void foo_expected(boolean a, boolean b) {
		if (a && b) {
			System.out.println("Ok");
		}
	}

	public void foo2(boolean a, boolean b, boolean c) {
		if (a) {
			if (b) {
				if (c) {
					System.out.println("Ok");
				}
			}
		}
	}

	public void foo2_expected(boolean a, boolean b, boolean c) {
		boolean condition = a && b && c;
		if (condition) {
			System.out.println("Ok");
			System.out.println("Ok");
			System.out.println("Ok");
			System.out.println("Ok");
			System.out.println("Ok");
			System.out.println("Ok");
			System.out.println("Ok");
		}
	}
}
