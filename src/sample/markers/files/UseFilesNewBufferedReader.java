package sample.markers.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class UseFilesNewBufferedReader {

	void fromNewFileReader() throws IOException {
		String location = "path/to/file";
		BufferedReader br = new BufferedReader(new FileReader(location));
		br.read();
		br.close();
		
	}
	
	void fromNewFile() throws IOException {
		String location = "path/to/file";
		BufferedReader br = new BufferedReader(new FileReader(new File(location)));
		br.read();
		br.close();

	}
	
	void declaringResourcesInTryWithResource() {
		try (FileReader reader = new FileReader(new File("path/to/file"));
				BufferedReader br = new BufferedReader(reader)) {
		    //...
		} catch (IOException e) {}
	}
	
	void providingCharsetManually() throws IOException {
		String location = "path/to/file";
		BufferedReader br = new BufferedReader(new FileReader(location, StandardCharsets.UTF_8));
		br.read();
		br.close();
	}
}
