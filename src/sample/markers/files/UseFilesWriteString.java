package sample.markers.files;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UseFilesWriteString {

	void bufferedWriterWitFileWriter() {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/test/testpath"))) {
			  bufferedWriter.write("Hello World!");
			} catch (IOException ioException) {
			  
			}
	}
	
	void specifyingCharset() {
		try (BufferedWriter bufferedWriter = new BufferedWriter(
			    new FileWriter("/home/test/testpath", StandardCharsets.UTF_8))) {
			  bufferedWriter.write("Hello World!");
			} catch (IOException ioException) {
			  //logError("File could not be written.", ioException);
			}
	}
	
	void initializedWithFilesNewBufferedWriter() {
		try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("/home/test/testpath"))) {
			  bufferedWriter.write("Hello World!");
			} catch (IOException ioException) {
			  //logError("File could not be written.", ioException);
			}
	}
	
	void missingCatchBlock() throws IOException {
		try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("/home/test/testpath"))) {
			  bufferedWriter.write("Hello World!");
		}
	}
}
