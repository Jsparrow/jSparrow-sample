package sample;

public class UseOffsetBasedStringMethods {
	
	private static final String HELLO_WORLD = "hello-world";
	
	void testWithMathAsVariableInAnonymousClassMethod() {
		int index = HELLO_WORLD.substring(6)
			.indexOf('d');

		class LocalClassWithoutMathAsField {
			void test() {
				int index = HELLO_WORLD.substring(6)
					.indexOf('d');
			}
		}

		Runnable r = new Runnable() {

			public void run() {
				
				String Math = "";
			}
		};
	}
	
	class ClassWithMaxMethod {
		void max() {
		}
	}

}
