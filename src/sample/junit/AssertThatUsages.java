package sample.junit;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AssertThatUsages {
	
	@Test
	public void test_withAssertThat() throws Exception {
		Calculator calc = new Calculator();
		assertThat(calc.divide(8, 2), equalTo(4));
	}
}
