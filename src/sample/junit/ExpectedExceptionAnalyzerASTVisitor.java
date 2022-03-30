package sample.junit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertThrows;
import static org.hamcrest.Matchers.*;

import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExpectedExceptionAnalyzerASTVisitor {


	@Rule
	public ExpectedException expectedException2 = ExpectedException.none();
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	private void throwRuntimeException() {
		throw new NullPointerException();
	}
	
	@Test
	public void explicitlyThrowingRuntimeException() {
		expectedException.expect(NullPointerException.class);
		throw new NullPointerException();
	}

	@Test
	public void expectingExceptionSuperType() throws IOException {
		expectedException.expect(Exception.class);
		throwIOException();
	}

	@Test
	public void throwExceptionSubtype() throws IOException {
		expectedException.expect(Exception.class);
		throw new IOException();
	}

	@Test
	public void multipleExpectCause() throws IOException {
		Matcher<Throwable> isIO = Matchers.is(new IOException());
		Matcher<Throwable> isNotFileException = Matchers.not(Matchers.is(new FileNotFoundException()));
		expectedException.expect(IOException.class);
		expectedException.expectCause(isIO);
		expectedException.expectCause(isNotFileException);
		throwIOException();
	}
	
	@Test
	public void testingExceptionCause() throws IOException {
		Matcher<Throwable> isNotFileException = not(is(new FileNotFoundException()));
		expectedException.expect(IOException.class);
		expectedException.expectCause(isNotFileException);
		throwIOException();
	}

	@Test
	public void multipleExpectMessage() throws IOException {
		expectedException.expect(IOException.class);
		expectedException.expectMessage("value");
		expectedException.expectMessage("value2");
		throwIOException();
	}

	@Test
	public void existingVarNameException() throws IOException {
		String exception = "";
		expectedException.expect(IOException.class);
		expectedException.expectMessage("value");
		throwIOException();
	}

	@Test
	public void statementsAfterThrowingException() throws IOException {
		expectedException.expect(IOException.class);
		throwIOException();
		System.out.println();
	}

	@Test
	public void expectMatcher() throws IOException {
		Matcher<Exception> matcher = null;
		expectedException.expect(matcher);
		throwIOException();
	}

	@Test
	public void multipleExpectedExceptionRules() throws IOException {
		expectedException.expect(IOException.class);
		expectedException2.expect(IOException.class);
		throwIOException();
	}

	@Test
	public void multipleNodesThrowingException() throws IOException {
		expectedException.expect(IOException.class);
		throwIOException();
		throwIOException();
	}

	@Test
	public void multipleExpectInvocations() throws IOException {
		expectedException.expect(IOException.class);
		expectedException.expect(FileNotFoundException.class);
		throwIOException();
	}

	@Test
	public void unsupportedMethod() throws IOException {
		expectedException.expect(IOException.class);
		expectedException.apply(null, null);
		throwIOException();
	}

	@Test
	public void fieldAccess() throws IOException {
		this.expectedException.expect(IOException.class);
		throwIOException();
	}

	@Test
	public void getterMethodForExpectedExceptions() throws IOException {
		getExpectedeException().expect(IOException.class);
		throwIOException();
	}

	private ExpectedException getExpectedeException() {
		return this.expectedException;
	}

	@Test
	public void undefinedMatcherType() throws IOException {
		Matcher<?> causeMatcher = null;
		expectedException.expect(IOException.class);
		expectedException.expectCause(causeMatcher);
		throwIOException();
	}

	@Test
	public void captureTypeMatcher() throws IOException {
		Matcher<? extends Throwable> causeMatcher = null;
		expectedException.expect(IOException.class);
		expectedException.expectCause(causeMatcher);
		throwIOException();
	}

	@Test
	public void throwableMatcher() throws IOException {
		Matcher<Throwable> causeMatcher = null;
		expectedException.expect(IOException.class);
		expectedException.expectCause(causeMatcher);
		throwIOException();
	}

	@Test
	public void expectMessage() throws IOException {
		Matcher<String> causeMatcher = null;
		expectedException.expect(IOException.class);
		expectedException.expectMessage(causeMatcher);
		throwIOException();
	}

	@Test
	public void expectMessageString() throws IOException {
		expectedException.expect(IOException.class);
		expectedException.expectMessage("some message");
		throwIOException();
	}

	@Test
	public void expectMessageContainsMatcher() throws IOException {
		expectedException.expect(IOException.class);
		expectedException.expectMessage(Matchers.containsString(""));
		throwIOException();
	}

	@Test
	public void exampleTest3() throws IOException {
		Matcher<?> causeMatcher = null;
		Matcher<? extends Throwable> typeMatcher = Matchers.isA(IOException.class);
		Matcher<Throwable> instanceMatcher = Matchers.is(new IOException());
		expectedException.expect(IOException.class);
		expectedException.expectMessage("Some message");
		expectedException.expectMessage(Matchers.containsString(""));
		expectedException.expectCause(causeMatcher);
		expectedException.expectCause(typeMatcher);
		throwIOException();
	}

	private void throwIOException() throws IOException {
	}
}
