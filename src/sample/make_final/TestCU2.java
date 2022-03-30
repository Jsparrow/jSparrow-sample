package sample.make_final;

public class TestCU2 {
	
	private void sampleMethodWithRunnable() {
		final Runnable runnable = new Runnable() {

			private String finalField;

			{
				finalField = "";
			}

			@Override
			public void run() {
			}
		};
	}

	public static class InnerClassWithConstructor {

		public static class InnerInnerClass {
			private int intValue = 0;
		}
	}

	private void sampleMethod() {
		final InnerClassWithConstructor.InnerInnerClass xInnerInnerClass = new InnerClassWithConstructor.InnerInnerClass();
		xInnerInnerClass.intValue = 1;
	}
}
