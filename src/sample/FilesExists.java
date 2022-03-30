package sample;

import java.nio.file.Files;
import java.nio.file.Path;

public class FilesExists {
	
	private void sampleMethod(Path path) {
		boolean exists = Files.exists(path);
		if(exists) {
			
		}
		
		exists = path.toFile().exists();
		if(exists) {
			
		}
	}

}
