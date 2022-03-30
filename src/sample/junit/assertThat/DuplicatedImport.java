package sample.junit.assertThat;

import static org.hamcrest.Matchers.equalToIgnoringCase;

import org.junit.Test;

public class DuplicatedImport {

	@Test
	public void usingOnDemandImports() {
		org.junit.Assert.assertThat("value", equalToIgnoringCase("value"));
	}
}
