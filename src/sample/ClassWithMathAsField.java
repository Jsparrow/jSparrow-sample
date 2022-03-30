package sample;

public class ClassWithMathAsField {
	
	private static final String HELLO_WORLD = "";
	
	String Math = "";

	class InnerClassWithoutMathAsField {

		void test() {
			int index = HELLO_WORLD.substring(6)
				.indexOf('d');
		}
	}
	
	class ClassWithMaxMethod {
		void max() {
		}
	}
}

