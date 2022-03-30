package sample.assertj;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractStringAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sample.optional.User;

public class SwapDescription {
	private User user;
	
	@BeforeEach
	void setUp() {
		user = new User();
	}
	
	@Test
	void shiftAssertJDescriptionsBeforeAssertions() {
		String actual = user.getMail();
		String expected = "Gold";
		assertThat(actual).isEqualTo(expected).as("Description");
		assertThat(actual).isEqualTo(expected).withFailMessage("Fail message");	
		assertThat(actual).isEqualTo(expected).describedAs("Error message");
		assertThat(actual).isEqualTo(expected).overridingErrorMessage("Error message");	
		
		assertThat("").isEqualTo("").as("Description");
		assertThat("").isEqualTo("").withFailMessage("Fail message");	
		assertThat("").isEqualTo("").describedAs("Error message");
		assertThat("").isEqualTo("").overridingErrorMessage("Error message");
		
		assertThat("").as("Description").isEqualTo("");
		assertThat("").withFailMessage("Fail message").isEqualTo("");	
		assertThat("").describedAs("Error message").isEqualTo("");
		assertThat("").overridingErrorMessage("Error message").isEqualTo("");	
		
		assertThat("").isEqualTo("").as("Description").isEqualTo("");
		assertThat("").isEqualTo("").as("Description1").isEqualTo("").as("Description2");
		
		AbstractStringAssert<?> stringAssert = null;
		stringAssert.as("Description");
	}
	
	@Test
	void parameterizedTypeArguments() {
		String actual = user.getMail();
		String expected = "Gold";
		assertThat(actual).isEqualTo(expected).<String>as("Description");
		assertThat(actual).<String>isEqualTo(expected).as("Description");
	}
}
