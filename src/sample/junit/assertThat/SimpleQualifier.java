package sample.junit.assertThat;

import static org.hamcrest.Matchers.equalToIgnoringCase;

import org.junit.Assert;
import org.junit.Test;

public class SimpleQualifier {
	
	@Test
	public void usingOnDemandImports() {
		Assert.assertThat("value", equalToIgnoringCase("value"));
	}

}
