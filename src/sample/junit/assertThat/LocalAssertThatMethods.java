package sample.junit.assertThat;

import static org.hamcrest.Matchers.equalToIgnoringCase;

import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LocalAssertThatMethods {

	@Category(LocalAssertThatMethods.class)
	@Test
	public void replacingAssertThat_noQualifier() throws Exception {
		assertThat("value", equalToIgnoringCase("value"));
	}
	
@Test
public void localMatcherAssertClass() throws Exception {
	MatcherAssert.assertThat("value", equalToIgnoringCase("value"));
}

static class MatcherAssert {
	public static void assertThat(String value, Matcher<String> object) {}
}
	
	private void assertThat(String value, Matcher<String> object) {}
}
