package sample.junit;

import static org.junit.Assert.assertThat;

import org.junit.Assert;

import static org.hamcrest.Matchers.equalToIgnoringCase;

import org.junit.Test;

public class AssertThatExamples {
	
	@Test
	public void replacingAssertThat_noQualifier() throws Exception {
		assertThat("value", equalToIgnoringCase("value"));
	}
	
	@Test
	public void replacingAssertThat_qualifiedName() throws Exception {
		Assert.assertThat("value", equalToIgnoringCase("value"));
	}
	
	@Test
	public void replacingAssertThat_fullyQualifiedName() throws Exception {
		org.junit.Assert.assertThat("value", equalToIgnoringCase("value"));
	}
	
	@Test
	public void hamcrestAssertThat() {
		org.hamcrest.MatcherAssert.assertThat("value", null);
	}
	


}
