package sample.markers.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UseBufferedReaderLines {

	void whileLoops() throws IOException {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("file.name.txt"))) {
		    String line;
		    while((line = bufferedReader.readLine()) != null) {
		        consume(line);
		    }
		}
	}

	void forLoopsWithInitializer() throws IOException {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("file.name.txt"))) {
		    for(String line; (line = bufferedReader.readLine()) != null;) {
		        consume(line);
		    }
		}
	}

	void forLoopsWithoutInitializer() throws IOException {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("file.name.txt"))) {
		    String line;
		    for(; (line = bufferedReader.readLine()) != null;) {
		        consume(line);
		    }
		}
	}
	
	
	void consume(String value) {
		
	}
}
