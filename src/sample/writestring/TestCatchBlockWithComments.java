package sample.writestring;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * Bug found in:<br>
 * package: org.neo4j.io.fs;<br>
 * class:FileUtils<br>
 *
 */

public class TestCatchBlockWithComments {

	void writeToFile(Path target, String text) throws IOException {
		try (Writer out = Files.newBufferedWriter(target, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
			// comment 1
			out.write(text);
			// comment 2
		} catch (IOException ioException) {
		}
	}

//	void testUsingBufferedWriterConstructor(String path, Charset charset, String text) throws IOException {
//		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, charset))) {
//			// comment 1
//			bufferedWriter.write(text);
//			// comment 2
//		} catch (IOException ioException) {
//		}
//	}
//	
//	void testUsingBufferedWriterConstructorTwice(String path, Charset charset, String text) throws IOException {
//		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, charset));
//				BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(path, charset))) {
//			// comment 1
//			bufferedWriter.write(text);
//			// comment 2
//			bufferedWriter2.write(text);
//			// comment 3
//		} catch (IOException ioException) {
//		}
//	}
}
