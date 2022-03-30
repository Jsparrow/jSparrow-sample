package sample.junit;

import junit.framework.TestCase;

public class ReturnValueWithInferredTypeAsArgumentTest extends TestCase {

	public void test() {
		assertEquals(getGenericReturnValue("message"), getGenericReturnValue("value"), getGenericReturnValue("value"));
		assertEquals(getGenericReturnValue("message"), getGenericReturnValue(0.0), getGenericReturnValue(0.0),
				getGenericReturnValue(0.0001));
	}

	<T> T getGenericReturnValue(T arg) {
		return arg;
	}

}
