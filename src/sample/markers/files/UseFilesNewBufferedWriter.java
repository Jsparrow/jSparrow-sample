package sample.markers.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class UseFilesNewBufferedWriter {

	void fromNewFileWriter() throws IOException {
		String location = "path/to/file";
		BufferedWriter br = new BufferedWriter(new FileWriter(location));
		br.write("");
		br.close();
		
	}
	
	void fromNewFile() throws IOException {
		String location = "path/to/file";
		BufferedWriter br = new BufferedWriter(new FileWriter(new File(location)));
		br.write("");
		br.close();

	}
	
	void declaringResourcesInTryWithResource() {
		try (FileWriter reader = new FileWriter(new File("path/to/file"));
				BufferedWriter br = new BufferedWriter(reader)) {
		    //...
		} catch (IOException e) {}
	}
	
	void providingCharsetManually() throws IOException {
		String location = "path/to/file";
		BufferedWriter br = new BufferedWriter(new FileWriter(location, StandardCharsets.UTF_8));
		
		br.close();
	}
}
