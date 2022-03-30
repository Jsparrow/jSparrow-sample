package sample.junit;

import static org.junit.Assert.assertThrows;

import java.io.IOException;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;
import org.junit.rules.ExpectedException;

public class ExamplesWithJUnitClasses {

	@Test(expected = RuntimeException.class)
	public void exampleTest() {

	}

	@Test
	public void exampleTest2() throws IOException {
		Matcher<?> causeMatcher = null;
		expectedException.expect(IOException.class);
		expectedException.expectMessage("Some message");
		expectedException.expectCause(causeMatcher);
		throwIOException();
	}

	@Test
	public void exampleTest3() throws IOException {
		expectedException.expect(IOException.class);
		throwIOException();
	}

	@Test
	public void exampleTest4() throws IOException {
		Matcher<?> causeMatcher = null;
		Matcher<String> messageMatcher = null;
		expectedException.expect(IOException.class);
		expectedException.expectMessage("Some message");
		expectedException.expectMessage(messageMatcher);
		expectedException.expectCause(causeMatcher);
		expectedException.apply(null, null);
		expectedException.handleAssertionErrors();
		expectedException.handleAssumptionViolatedExceptions();
		expectedException.isAnyExceptionExpected();
		expectedException.reportMissingExceptionWithMessage("Missing exception");
		expectedException.none();

		throwIOException();
	}

	@Test
	public void exampleTest5() throws IOException {
		assertThrows(IOException.class, () -> {
			throw new IOException();
		});
	}
	


	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void newInstanceCreation_original() throws IOException {
		expectedException.expect(IOException.class);
		new InnerClass();
	}

	class InnerClass {
		public InnerClass() throws IOException {throw new IOException();}
	}

	@Test
	public void newInstanceCreation() throws IOException {
		assertThrows(IOException.class, () -> new InnerClass());
	}

	private void throwIOException() throws IOException {
	}
}
