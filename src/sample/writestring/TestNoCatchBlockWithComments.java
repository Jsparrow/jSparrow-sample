package sample.writestring;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Bug found in:<br>
 * package: org.neo4j.io.fs;<br>
 * class:FileUtils<br>
 *
 */

public class TestNoCatchBlockWithComments {

	void testUsingFilesNewBufferedWriter2Times() throws IOException {
		String text = "Hello World!";
		Path path = Paths.get("/home/test/testpath");
		try (Writer out = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
				Writer out2 = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
			// comment 1
			out.write(text);
			// comment 2
			out2.write(text);
			// comment 3
		}
	}
}
