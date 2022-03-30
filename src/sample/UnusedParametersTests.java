package sample;

import java.util.List;

import com.sun.istack.NotNull;

public class UnusedParametersTests {

	public UnusedParametersTests(List<String> values) {
		methodWithUnusedParameter("value1", "value2");
		annotatedUnusedParameter("value1", "value2");
		values.forEach(this::unusedParameter);

	}

	private void unusedParameter(String value) {
	}

	private void methodWithUnusedParameter(String value, final String unusedParameter) {
		System.out.println(value);
	}

	private void annotatedUnusedParameter(String value, @NotNull String unusedParameter) {
		System.out.println(value);
	}

}
