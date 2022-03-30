package sample.formatted;

import java.util.Locale;

public class UsingStringFormatted {
	
	void formattingStrings() {
		String value = String.format("This is my %d value. %s job!", 1, "Good");
		
		String template = "This is another %s template. \nPoints: %d\nName: %s";
		String.format(template, 5, "Diti");
		String.format(template.trim(), 5, "Diti");
		String.format(template.substring(2), 5, "Diti");
	}
	
	void formattingTextBlocks() {
		String value = String.format(
				"""
				This is a text block.
				First Name: %s,
				Last Name: %s,
				Position: %d		
				"""
				, "John", "Snow", 1);
		
		
	}
	
	void nullLiterals() {
		String value = String.format(null, null);
		String.format(null);
	}
	
	void usingLocale() {
		String value = String.format(Locale.ITALY, "Il pomeriggio e troppo azzurro. %s ", "Adriano");
		
	}

	
	void noParameters() {
		"".formatted();
	}
}
