package sample.junit.assertThat;

import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.Assert.*;

import org.junit.Test;

public class OnDemandImports {
	
	@Test
	public void usingOnDemandImports() {
		assertThat("value", equalToIgnoringCase("value"));
	}
	
	@Test
	public void ussingAssertions() {
		assertEquals("value", "value");
	}

}
